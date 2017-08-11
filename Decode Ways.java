public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) { return 0; }
        if (s.charAt(0) == '0') { return 0; }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        
        for (int i = 1 ; i < s.length() ; i++) {
            if (s.charAt(i) - '0' != 0) {
                dp[i] = dp[i - 1];
            }
            
            int val = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if (i == 1 && val <=26 && val >= 10) {
                dp[i] = dp[i] + 1;
            }
            
            if (i >= 2 ) {
                if (val <= 26 && val >= 10) {
                        dp[i] = dp[i] + dp[i-2];
                }
            }
        }
        return dp[s.length()-1];
    }
}