public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                diff = Math.min(diff, target - (nums[left] + nums[right]));
                left++;
            } else {
                // nums[left] + nums[right] >= target 大減小 防止為負
                diff = Math.min(diff, (nums[left] + nums[right]) - target);
                right--;
            }
        }
        return diff;
    }
}