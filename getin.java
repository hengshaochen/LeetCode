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
// Correct
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        // 找下一個應該要接的點
        TreeLinkNode nextNode = root.next;
        while (nextNode != null) {
            if (nextNode.left != null) {
                nextNode = nextNode.left;
                break;
            } else if (nextNode.right != null) {
                nextNode = nextNode.right;
                break;
            }
            nextNode = nextNode.next;
        }
        
        // 接上去, 右邊優先, 在接左邊
        if (root.right != null) {
            root.right.next = nextNode;
            if (root.left != null) {
                root.left.next = root.right;
            }
        } else if (root.left != null) {
                root.left.next = nextNode;
        }
        // 先走右邊在走左邊
        connect(root.right);
        connect(root.left);
        
    }
}


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
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum = sum + (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }
}

// 50. Pow
// 好方法, 把次方用2進位來算
public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, long n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        double ans = 1;
        double now_mul = x;
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= now_mul;
            }
            now_mul *= now_mul;
            n = n / 2;
        }
        
        return ans;
    }
}

// 42. Trapping Rain Water

 
// 62. Unique Paths
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

// 63. Unique Paths II
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid == null) {
             return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
// Add two numbers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /*
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            
            sum += (l1 != null) ? l1.val : 0;
            sum += (l2 != null) ? l2.val : 0;
            
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            
            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2; 
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        
        return dummy.next;
    }
}

// 69. Sqrt(x)
// O(n^0.5)
class Solution {
    public int mySqrt(int x) {
        long ans = 1;
        
        while (ans * ans <= x) {
            ans += 1;
        }
        
        return (int) ans - 1;
    }
}

// binary search: O(logn)
class Solution {
    public int mySqrt(int x) {
        // 把這個問題轉成binary search, 要在1~x中找到一個數字, 該數字^2 會> x的
        long start = 1;
        long end = x;
        
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long cur = mid * mid;
            // cur >= x 代表目標一定在現在end的左邊或是end
            if (cur >= x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        // 先看end若end符合就回傳end, 因為end符合就不可能是start, 因start一定也符合 start * start < x的條件
        if (end * end <= x) {
            return (int)end;
        }
        return (int)start;
        
    }
}

// 160. Intersection of Two Linked Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个链表的长度不定，但是交叉节点的后续节点全部相同，所以先求得每个链表的长度lenA和lenB
        // 将较长的链表先移动|lenA−lenB|个位置，然后同时后移，遇到的第一个值相等的节点既是要求的交叉节点。
        
        ListNode copyA = headA;
        ListNode copyB = headB;
        int lengthA = 0, lengthB = 0;
        while (copyA != null) {
            copyA = copyA.next;
            lengthA++;
        }
        while (copyB != null) {
            copyB = copyB.next;
            lengthB++;
        }
        copyA = headA;
        copyB = headB;
        
        int diffLength = Math.abs(lengthA - lengthB);
        
        while (diffLength > 0) {
            if (lengthA > lengthB) {
                copyA = copyA.next;
            } else {
                copyB = copyB.next;
            }
            diffLength--;
        }
        
        while (copyA != null && copyB != null) {
            if (copyA == copyB) {
                return copyA;
            }
            copyA = copyA.next;
            copyB = copyB.next;
        }
        return null;
        
    }
}

// 98 Validate Binary Search Tree
// Version1: Recursive
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        // 向右更新min, 向左更新max
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        
        dfs(root, min, max);
        
        return ans;
    }
    
    void dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return;
        }
        if (root.val <= min || root.val >= max) {
            ans = false;
            return;
        }
        
        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
        
    }
}
// Version2: Iterative
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // 思路2: BST走中序輸出會是小到大排序好, 因此設一個pre跟cur, 如果是bst的話, cur的值一定會比pre大
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        while (!s.empty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (pre != null && cur.val <= pre.val) {
                return false;
            }
            // 存前一個node
            pre = cur;
            cur = cur.right;
        }
        
        return true;
        
    }
}

// 268. Missing Number
class Solution {
    public int missingNumber(int[] nums) {
        // {0,1,2,3} XOR {0,1,3}
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
        }
        
        Iterator it = set.iterator();
        return (int) it.next();
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        // {0,1,2,3} XOR {0,1,3}
        
        int ans = 0;
        // 0,1,3 length = 3, 要把0 ^ 1 ^ 2 ^ 3
        for (int i = 0; i <= nums.length; i++) {
            ans = ans ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}

// 53. Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = 0;  // min要是0, 不能是MAX_VALUE
        
        // 算prefix
        int prefix = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefix = prefix + nums[i];
            // 要先寫max這行再寫min這行
            if (max < prefix - min) {
                max = prefix - min;
            }
            if (min > prefix) {
                min = prefix;
            }
        }
        
        return max;
    }
}

// 78. Subsets
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(0, nums, cur, ans);
        return ans;
    }
    
    void dfs(int start, int[] nums, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(cur));
        
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(i + 1, nums, cur, ans);
            cur.remove(cur.size() - 1);
        }
        
        
    }
}


// 215. Kth Largest Element in an Array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Version1: Priority Queue
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        };
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, cmp);
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            } else {
                if (minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}

// 49. Group Anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 建立一個HashMap, key是string, value是該string的答案arraylist
        // 針對每一個String排序, 若排序後的字在hashmap中, 則加入, 不在則新增至map中
        List<List<String>> ans = new ArrayList<>();
        
        // Arrays.sort不支援String, 要用char
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            String sorted_string = new String(cur);
            if (!map.containsKey(sorted_string)) {
                List<String> newlist = new ArrayList<>();
                newlist.add(strs[i]);
                map.put(sorted_string, newlist);
            } else {
                map.get(sorted_string).add(strs[i]);
            }
        }
        
        // 遍歷hashmap放到答案中
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}

// 386. Lexicographical Numbers
class Solution {
    public List<Integer> lexicalOrder(int n) {
        // 法1. 把所有int轉成String, 接著sort比較 --> 超時 O(n + nlogn + n)
        String[] str = new String[n];
        for (int i = 1; i <= n; i++) {
            // Integer to String
            str[i - 1] = String.valueOf(i);
        }
        
        Arrays.sort(str);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            // String to Integer
            ans.add(Integer.parseInt(str[i]));
        }
        
        return ans;
    }
}


// 139. Word Break
public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) { return true; }
        
        HashMap<String, Boolean> map = new HashMap<>();
        //boolean ans = false;
        
        // DFS去走訪所有切割方式 + 剪枝
        return dfs(s, dict, map);
        
        //return ans;
    }
    
    boolean dfs(String s, Set<String> dict, HashMap<String, Boolean> map)
    {
        // 已經算過了（在Map中）直接return
        if (map.containsKey(s)) {
            return map.get(s);
        }
        // 如果s在字典中, 答案直接變true, 因為可以左邊切為空集合, 右邊為s
        if (dict.contains(s)) {
            map.put(s, true);
            return true;
        }
        
        // DFS遞回 + 剪枝
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            
            if (dfs(left, dict, map) == true && dict.contains(right)) {
                map.put(s, true);
                return true;
            }
        }
        // 如果s的所有切割方式都不行組成字典中的字
        map.put(s, false);
        return false;
    }
}

// 151. Reverse Words in a String
public class Solution {
    public String reverseWords(String s) {
        String[] sp = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--) {
            if (!sp[i].equals("")) {
                ans.append(sp[i] + " ");
            }
        }
        if (ans.length() == 0) {
            return "";
        }
        // 去除最後一個多得空格
        return ans.substring(0, ans.length() - 1);
    }
}

// 102. Binary Tree Level Order Traversal
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null) { return ans; }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        // while (q != null) 會有bug 改成isEmpty() ok!
        while (!q.isEmpty()) {
            int LevelSize = q.size();
            ArrayList<Integer> local = new ArrayList<Integer>();
            for (int i=0 ; i < LevelSize ; i++) {
                TreeNode currentNode = q.remove();
                if (currentNode.left != null) { q.add(currentNode.left); }
                if (currentNode.right != null) { q.add(currentNode.right); }
                local.add(currentNode.val);
            }
            ans.add(local);
        }
        return ans;
    }
}

// 103. Binary Tree Zigzag Level Order Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) { return ans; }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        // while (q != null) 會有bug 改成isEmpty() ok!
        boolean isEven = false;
        while (!q.isEmpty()) {
            int LevelSize = q.size();
            ArrayList<Integer> local = new ArrayList<Integer>();
            for (int i=0 ; i < LevelSize ; i++) {
                TreeNode currentNode = q.remove();
                if (currentNode.left != null) { q.add(currentNode.left); }
                if (currentNode.right != null) { q.add(currentNode.right); }
                local.add(currentNode.val);
            }
            if (isEven == false) {
                ans.add(local);
                isEven = true;
            } else {
                Collections.reverse(local);
                ans.add(local);
                isEven = false;
            }
        }
        return ans;
    }
}

// 88. Merge Sorted Array
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // [1,3,5,9]
        // [2,10]
        int idx = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[idx--] = nums2[p2--];
            } else {
                nums1[idx--] = nums1[p1--];
            }
        }
        while (p2 >= 0) {
            nums1[idx--] = nums2[p2--];
        }
    }
}

// 3. Longest Substring Without Repeating Characters

// 225. Implement Stack using Queues
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // 每次加進來後反轉
        q.add(x);
        // 只要跑size - 1次就可以把剛剛加入的放到最前面了
        for (int i = 1; i < q.size(); i++) {
            q.add(q.remove());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// 105. Construct Binary Tree from Preorder and Inorder Traversal

// 141. Linked List Cycle
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        if (head == null) { return false; }
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast != slow) {
            // 若任一指標都指向null --> 沒cycle
            // 要加fast.next是因為避免outOfBoundary,
            // 若fast.next為null, fast.next.next會outOfBoundary
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 若fast == true, 代表快慢指標相遇 --> 有cycle
        return true;
    }
}

// 208. Implement Trie (Prefix Tree)

// 230. Kth Smallest Element in a BST

// 5. Longest Palindromic Substring

// 26. Remove Duplicates from Sorted Array
public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int i = 0;   // i的左邊包含i, 都是沒有重複的
        int j = 1;   // j去找和i不同的
        
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            } 
            j++;
        }
        return i + 1;
    }
}

// 33. Search in Rotated Sorted Array
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) { return -1; }
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                // red line
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // green line (nums[mid] < nums[start])
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}

// 13. Roman to Integer
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            // 當前 > 前面 --> 把上次加入的還原 並 加入(當前-前一個) 
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                sum = sum - map.get(s.charAt(i - 1)) + ( map.get(s.charAt(i)) - map.get(s.charAt(i - 1)) );
            }
            // 前面 >= 當前 --> 直接加入當前值
            else {
                sum = sum + map.get(s.charAt(i));
            }
        }
        return sum;
    }
}

// 8. String to Integer (atoi)

// 63 Unique Paths II
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid == null) {
             return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

// 297. Serialize and Deserialize Binary Tree

// 172. Factorial Trailing Zeroes

// 101. Symmetric Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean ans = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return ans; }
        helper(root.left, root.right);
        return ans;
    }
    public void helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return;
        }
        
        if ((l == null && r != null) || (l != null && r == null)) {
            ans = false;
            return;
        }
        
        if (l.val == r.val) {
            helper(l.left, r.right);
            helper(l.right, r.left);
        } else {
            ans = false;
        }
        
    }
}

// 79. Word Search

// 100. Same Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null ) return true;
        isSameTreeHelper(p, q);
        return same;
    }
    private void isSameTreeHelper(TreeNode p, TreeNode q) {
        if(p!=null && q!=null)
        {
                isSameTreeHelper(p.left,q.left);
                isSameTreeHelper(p.right,q.right);
                if (p.val != q.val) {
                    same = false;
                }
        }
        else if( (p == null && q != null) || (p != null && q == null) )
        {
            same = false;
        }
    }
}

// 189. Rotate Array


// 15. 3Sum (Three Sum)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            // 去重
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, nums.length - 1, target);
        }
        return ans;
    }
    public void twoSum(int[] nums, int start, int end, int target) {
        int i = start;
        int j = end;
        
        while (i < j) {
            List<Integer> local = new ArrayList<>();
            if (nums[i] + nums[j] == target) {
                local.add(-target);
                local.add(nums[i]);
                local.add(nums[j]);
                ans.add(local);
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}

// 266. Palindrome Permutation


// 547. Friend Circles

// 11. Container With Most Water

// 158. Read N Characters Given Read4 II - Call multiple times

// 570. Managers with at Least 5 Direct Reports

// 131. Palindrome Partitioning

// 274. H-Index

// 669. Trim a Binary Search Tree

// 714. Best Time to Buy and Sell Stock with Transaction Fee