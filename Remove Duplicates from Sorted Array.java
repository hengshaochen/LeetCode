public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int i = 0;   // i的左邊包含i, 都是沒有重複的
        int j = 1;   // j去找和i不同的
        
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            } 
            j++;
        }
        return i + 1;
    }
}

// II
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int i = 0;
        int j = 1;
        
        int count = 0;
        
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                if (count < 1) {
                    count++;
                    nums[++i] = nums[j];
                }
            } else {
                count = 0;
                nums[++i] = nums[j];
            }
            
            j++;
        }
        return i + 1;
        
    }
}