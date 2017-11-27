// Add two number II
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        
        // traverse 2 lists
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        
        // add two list, and connect the list in rev order
        // 3+4 = 7 tail
        // 4+6 = 0 cur
        // cur -> tail  0 --> 7
        ListNode tail = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if (!s1.isEmpty()) {
                sum += s1.pop().val;
            }
            if (!s2.isEmpty()) {
                sum += s2.pop().val;
            }
            carry = sum / 10;
            sum = sum % 10;
            
            ListNode cur = new ListNode(sum);
            cur.next = tail;
            tail = cur;
        }
        if (carry != 0) {
            ListNode cur = new ListNode(carry);
            cur.next = tail;
            tail = cur;
        }
        return tail;
    }
}


// 138. Copy List with Random Pointer
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
        copyNode(head);
        copyRandom(head);
        
        return split(head);
    }
    public void copyNode(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            
            head = head.next.next;
        }
    }
    
    public void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.next.random.next;
            }
            head = head.next.next;
        }
    }
    
    public RandomListNode split(RandomListNode head) {
        RandomListNode newNode = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            head = head.next;
        }
        return newNode;
    }
}

// 121. Best time to buy and sell stock
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) { return 0; }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(prices[i] - min, profit);
        }
        return profit;
        /* O(n) 超時
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] <= max || prices[j] == prices[j - 1]) {
                    continue;
                }
                if (prices[j] > prices[i]) {
                    int cur_profit = prices[j] - prices[i];
                    max = Math.max(max, cur_profit);
                }
            }
        }
        return max;
        */
    }
}

// 692. Top K Frequent Words
public class Solution {
    /*
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // 不能使用k = 0來建立priority queue
        if (k == 0) {
            return new String[0];
        }
        
        // Build HashMap
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        
        // Traverse Map, and build Priority Queue(Min heap)
        Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() != e2.getValue()) {
                    return e1.getValue() - e2.getValue();
                }
                // **** alphabetical order
                return e2.getKey().compareTo(e1.getKey());
            }
        };
        PriorityQueue<Map.Entry<String, Integer>> minheap = new PriorityQueue<Map.Entry<String, Integer>>(k, cmp);
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minheap.size() < k) {
                minheap.offer(entry);
            } else {
                // **** 如果minheap root的出現頻率 < entry --> 加入
                // **** 撋果minheap root的出現頻率 == entry, 字母序小的加入
                // ex: a freq = 2, e freq = 2 --> a加入
                // 多個條件比較, 使用comparator
                if (cmp.compare(entry, minheap.peek()) > 0) {
                    minheap.poll();
                    minheap.offer(entry);
                }
            }
        }
        
        // put the answer in String[]
        String[] ans = new String[k];
        for (int i = 0; i < k; i++) {
            ans[k - 1 - i] = minheap.poll().getKey();
        }
        
        return ans;
    }
}

// 1. two sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}

// 283. move zeros
class Solution {
    public void moveZeroes(int[] nums) {
        // 要讓i的左邊都為0
        // j來traverse整個list, j指向非0就和i交換, 交換完i就可以往右移動一格了
        // 1,2,0,3,0,5
        //     i
                j
        // 1,2,3,0,0,5
        //       i
                   j
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        
    }
}

// Min Stack
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        // 若min_stack的頭比新來的值大 or 為空 --> push x進入
        if (min_stack.isEmpty() || min_stack.peek() > x) {
            min_stack.push(x);
        } else {
            min_stack.push(min_stack.peek());
        }
        stack.push(x);
    }
    
    public void pop() {
        min_stack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// 387. First Unique Character in a String
class Solution {
    public int firstUniqChar(String s) {
        // use hashmap, scan 1 times
        //HashMap<Character, Integer> map = new HashMap<>();
        int[] map = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] += 1;
        }
        
        // scan again, and get the cur char value in map 
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) {
                return i;
            }    
        }
        
        return -1;
    }
}

// 117. Populating Next Right Pointers in Each Node


// 20. Valid Parentheses
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
        if (c == '(')
            stack.push(')');
        else if (c == '{')
            stack.push('}');
        else if (c == '[')
            stack.push(']');
        else if (stack.isEmpty() || stack.pop() != c)
            return false;
    }
    return stack.isEmpty();
}

// 56. Merge Interval
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) {
            return ans;
        }
        // 按照start來sort, 之後就能只比較end
        /*
        [1,3] [2,6] --> [1,6]
        [1,6] [8,10] --> [1,6] [8,10]
        [8,10], [15,18] --> [1,6] [8,10] [15,18]
        */
        
        Comparator<Interval> cmp = new Comparator<Interval>() {
            public int compare(Interval e1, Interval e2) {
                return e1.start - e2.start;
            }    
        };
        Collections.sort(intervals, cmp);
        
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                // 合併
                pre.end = Math.max(pre.end, cur.end);
            } else {
                ans.add(pre);
                pre = cur;
            }
        }
        ans.add(pre);
        
        return ans;
    }
}

// 146. LRU Cache
class LRUCache {
    class Node {
        Node pre;
        Node next;
        int key;
        int value;
        Node(int key, int value) {
            this.pre = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node current = map.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        move_to_tail(current);
        
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            // 刪除head.next
            map.remove(head.next.key); 
            head.next = head.next.next;
            head.next.pre = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        move_to_tail(insert);
    }
    public void move_to_tail(Node current) {
        /*
        tail.pre.next = current;
        current.pre = tail.pre;
        current.next = tail;
        tail.pre = current;
        */
        Node temp = tail.pre;
        tail.pre = current;
        current.next = tail;
        current.pre = temp;
        temp.next = current;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// 206. Reverse Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // input:  1 -> 2 -> 3
        // output: 1 <- 2 <- 3
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}

// 122. Best Time to Buy and Sell Stock II
