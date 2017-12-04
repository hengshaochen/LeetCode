class Solution {
    public void rotate(int[] nums, int k) {
        // 萬一k比nums.length還大
        k = k % nums.length;
        /*
        k = 3
        length = 7
            7 - 3 = 4
        1 2 3 4 | 5 6 7
        4 3 2 1 | 7 6 5
        5 6 7 | 1 2 3 4
        */
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}