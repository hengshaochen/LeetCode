public class Solution {

    private Queue<Integer> min_heap;
    private int kSize;
    
    public Solution(int k) {
        // initialize your data structure here.
         min_heap = new PriorityQueue<>();
         kSize = k;
    }

    public void add(int num) {
        if (min_heap.size() == kSize) {
            int min = min_heap.poll();
            if (min < num) {
                min_heap.add(num);
            } else {
                min_heap.add(min);
            }
        } else {
            min_heap.add(num);
        }
    }

    public List<Integer> topk() {
		    
        List<Integer> ans = new ArrayList<>();
        
        if (min_heap.size() == kSize) {
            for (int i = 0; i < kSize; i++) {
                ans.add(min_heap.poll());
            }
            // 加回priority queue
            for (int i = 0; i < kSize; i++) {
                min_heap.add(ans.get(i));
            }
        } else {
            int pollTimes = min_heap.size();
            
            for (int i = 0; i < pollTimes; i++) {
                ans.add(min_heap.poll());
            }
            for (int i = 0; i < pollTimes; i++) {
                min_heap.add(ans.get(i));
            }
        }
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }
};