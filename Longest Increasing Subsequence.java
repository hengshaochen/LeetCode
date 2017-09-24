// Version2: my version
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
   
    
    public int longestIncreasingSubsequence(int[] nums) {
        int[] x = new int[nums.length];
        // x[i] 代表由“某個位置”到達下標i時的LIS
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            x[i] = 1;
            for (int j = 0; j < i; j++) {
                // i是當前, j是i之前的所有數的掃描
                if (nums[j] < nums[i]) {
                    // 如果前面的位置有比當前位置的大, 把前面位置的加上1,
                    // 因為進到這個if代表前面位置的value一定比當前位置value小
                    // 代表可以從前面位置跳到i這個位置
                    if (x[j] >= x[i]) {
                        x[i] = x[j] + 1;
                    }
                }
            }
            if (max < x[i]) {
                max = x[i];
            }
        }
        return max;
    }
}

// Version1
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
   
    
    public int longestIncreasingSubsequence(int[] nums) {
        int []f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
                System.out.println("i:" + i + " j:" + j);
                System.out.println("f[i]" + f[i]);
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}