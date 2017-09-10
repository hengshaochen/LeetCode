class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) { return; }
        // left指標的左邊都是排好的,(left找不是目標值) right是要找目標值
        int left = 0;
        for (int i = 0; i < 3; i++) {
            int right = nums.length - 1;
            while (left <= right) {
                while (left <= right && nums[left] == i) {
                    left++;
                }
                while (left <= right && nums[right] != i) {
                    right--;
                }
                
                // swap
                if (left <= right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
            }
        }
    }
}