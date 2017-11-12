public class Solution {
    /*
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) { return -1; }
        // 選最後一個數字當target
        int start = 0;
        int end = nums.length - 1;
        int target = nums[nums.length - 1];
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                // 如果當前數 > 最後一個數 --> 往右找
                start = mid;
            } else {
                // 如果當前數 == 最後一個數 --> 往左找看有沒有更小
                // 如果當前數 < 最後一個數  --> 往左找看有沒有更小
                end = mid;
            }
        }
        
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}

// Follow-up
public class Solution {
    /*
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) { return -1; }
        // 選最後一個數字當target
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // 如果當前數 == 最後一個數 --> 去掉最後面那個數, 不會影響答案(因為代表最後一個數字不是最小的)
                end--;  // 唯一更改的地方！
            }
            else if (nums[mid] > nums[end]) {
                // 如果當前數 > 最後一個數 --> 往右找
                start = mid;
            } else {
                // 如果當前數 < 最後一個數  --> 往左找看有沒有更小
                end = mid;
            }
        }
        
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}