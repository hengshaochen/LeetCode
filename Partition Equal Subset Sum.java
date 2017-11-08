public class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len ; i++ ){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        sum /= 2;
        boolean [] dp = new boolean[20000];
        for(int i = 0; i <=sum ; i ++)
            dp[i] = false;
        dp[0] = true;
        for(int i = 0; i < len; i++){
            for(int j= sum ; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}