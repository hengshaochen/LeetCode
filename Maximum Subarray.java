public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) { return 0; }
        int sum = 0;
        int max = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            
            // 若全部為負數, 要先寫max = 這行, 再寫sum = 這行
            // DP, 若sum < 0, 丟棄目前加總的, 從下一輪開始繼續加總
            if (sum > max) {
                max = sum;
            }
            
            if (sum < 0) {
                sum = 0;
            }
            //max = Math.max(max, sum);
            //sum = Math.max(0, sum);
        }
        return max;
    }
};