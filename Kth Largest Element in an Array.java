// 法1: Priority Queue, Time: O(nlogk) Space: O(k)
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

// 法2: TreeMap, 基本上不能用, 因為Set不能有重複元素
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Version2: TreeSet
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                // 排序大到小
                return e2 - e1;
            }
        };
        TreeSet<Integer> maxTS = new TreeSet<>(cmp);
        
        for (int i = 0; i < nums.length; i++) {
            maxTS.add(nums[i]);
        }
        
        Iterator it = maxTS.iterator();
        int count = 1;
        int ans = 0;
        
        // 注意：it.next()不能寫在if裡面, 他必須一直遍歷, 才能一直往下走.
        while (it.hasNext()) {
            ans = (int) it.next();
            if (count == k) {
                break;
            }
            count++;
        }
        
        return ans;
    }
}