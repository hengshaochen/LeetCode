public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // Two Ptr
        int[] result = new int[2];
        if (nums == null || nums.length == 0) { return result; }
        
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
            
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}