public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                end = mid; // 若要找first position
                // start = mid; 若要找last position
            } else if (target > nums[mid]) {
                start = mid;
            } else if (target < nums[mid]) {
                end = mid;
            }
        }
        
        // 若要找first position, start放前面, 若要找last position, end放前面
        if (nums[start] == target) { return start; }
        if (nums[end] == target) { return end; }
        return -1;
    }
}