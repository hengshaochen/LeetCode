public class Solution {
    /*
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        Comparator<Integer> cmp = new Comparator<Integer> () {
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        };
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, cmp);
        
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = minHeap.poll();
        }
        
        return ans;
    }
}