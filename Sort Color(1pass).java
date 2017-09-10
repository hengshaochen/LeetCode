class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) { return; }
        
        int left = 0, i = 0, right = nums.length - 1;
        // left左邊都是0, right的右邊都是2
        
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, right, i);
                right--;
            }
        }
    }
    private void swap(int[] nums, int start, int end) { 
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}