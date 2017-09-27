public class Solution {
    /*
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                /*
                不理解
                System.out.println(i + " " + j);
                System.out.println(i+j*j);
                System.out.println();
                */
                
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}