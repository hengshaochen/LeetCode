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