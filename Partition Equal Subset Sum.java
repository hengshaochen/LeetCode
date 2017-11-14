public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        // sum為奇數一定不可能平分成兩個set
        if (sum % 2 != 0) {
            return false;
        }
        
        // partitioned into two subsets such that the sum of elements in both subsets is equal
        sum = sum / 2;
        
        
        // dp[i][j] 代表取0 ~ i -1的數字選擇下, 是否可能組成j這個target number
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        
        // base case:
        dp[0][0] = false;
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        
        // Transition function
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // 這次取：找前一次有沒有sum == j - 這次的值 （如果j < 這次的值) 代表加爆, 跳過
                // 這次不取：找前一次有沒有sum == j的值
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}

// 優化空間
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