public class Solution {
    /*
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // 和前一個的數字比較, 如果比左邊大 --> 上升階段 --> start = mid
        // 如果比左邊小 --> 下降階段 end = mid
        if (nums.length == 0 ) { return -1; }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        System.out.println(start);
        System.out.println(end);
        
        if (nums[start] > nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}

