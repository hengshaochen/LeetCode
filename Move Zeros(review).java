// Move Zeros, 保持相對順序
public class Solution {
    /*
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        int i = 0; // left element of i all non-zero
        int j = 0; // j find not zero element
        
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}

// Move Zeros, 最小寫入次數（相對順序改變）
public class Solution {
    /*
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        int i = nums.length - 1; // i的右邊都為0
        int j = nums.length - 1; // j找為0的元素(現在i要放的位置)
        
        while (j >= 0) {
            if (nums[j] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i--;
            }
            j--;
        }
    }
}