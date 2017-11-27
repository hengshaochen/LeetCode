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

// Two Sum
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

// Move zero
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