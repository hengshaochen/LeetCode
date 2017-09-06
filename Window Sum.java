public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // 一個指標指向目前的起點, 另一個指標從目前的起點 向右移動 k - 1次
        if (nums.length == 0 || nums == null) { return new int[0]; }
        int[] sums = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = 0; j < k; j++) {
                sums[i] = sums[i] + nums[j + i];
            }
        }
        return sums;
    }
}