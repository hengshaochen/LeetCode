class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // /用HashMap統計出現次數
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        // 把Priority Queue(Min Heap)結合HashMap, 重寫Comparator, 讓他依照HashMap的Value來調整PQ
        Comparator<Map.Entry<Integer, Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue() - e2.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<Map.Entry<Integer, Integer>>(k, cmp);
        
        // 遍歷HashMap建立Priority Queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minheap.size() < k) {
                minheap.offer(entry);
            } else {
                if (minheap.peek().getValue() < entry.getValue()) {
                    minheap.poll();
                    minheap.offer(entry);
                }
            }
        }
        /*
        List<Integer> ans = new ArrayList<>();
        // 把最後最高頻率的k個輸出到答案
        for (int i = 0; i < k; i++) {
            ans.add(0, minheap.poll().getKey());
        }
        */
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : minheap) {
            ans.add(0, entry.getKey());
        }
        return ans;
    }
}