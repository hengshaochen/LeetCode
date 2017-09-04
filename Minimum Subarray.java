public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int maxSum = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        return min;
    }
}