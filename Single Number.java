class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if (nums[i] == nums[i + 1]) {
                i = i + 2;
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}

// XOR
public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }
}
