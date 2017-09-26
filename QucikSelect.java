public class Solution {
    /*
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) { return -1; }
        
        return quickSelect(nums, k, 0, nums.length - 1);
    }
    public int quickSelect(int[] nums, int k, int start, int end) {
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        // 往左
        if (start + k - 1 <= right) {
            return quickSelect(nums, k, start, right);
        }
        // 往右
        if (start + k - 1 >= left) {
            return quickSelect(nums, k - (left - start), left, end);
        }
        // 剛好是中間的
        return nums[right + 1];
    }
}