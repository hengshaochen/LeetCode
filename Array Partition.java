class Solution {
    public int arrayPairSum(int[] nums) {
        int ans = 0;
        // 排序, 每次把當前最小的兩個取min並加入到ans中
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i += 2) {
            int cur = Math.min(nums[i], nums[i + 1]);
            ans += cur;
        }
        
        return ans;
    }
}