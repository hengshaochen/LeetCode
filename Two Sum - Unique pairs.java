public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // Two Ptr
        int count = 0;
        if (nums == null || nums.length == 0) { return 0; }
        
        Arrays.sort(nums);
        
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                count++;
                
                i++;
                j--;
                
                // **注意加入防止指標越界條件i < j , 就不可能有新的pair --> stop!
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
                
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        }
        return count;
    }
}