// Version 2: Prefix Sum
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}