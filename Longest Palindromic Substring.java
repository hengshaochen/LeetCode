// 法1: 暴力法 O(n^3)
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++ ) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            
            if (Character.toLowerCase(s.charAt(i)) !=
                Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
            i++;
            j--;
        }
        return true;
    }
}

// 法2: DP, 如果左右兩邊相等, 用dp算過且紀錄過的中間是回文 --> 是回文
// 去除中間要重算是不是回文的冗余 O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        
        boolean[][] dp = new boolean[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 如果最左右兩邊的相等 且
                // 中間（之前dp已經存起來, 算過的）也是true 或 中間長度 < 1, 代表中間是回文 --> 這個新的長度的就是回文
                // 因為中間長度若是1, aba 中間只有一個b, 中間一定是回文. 因此要多一個or條件 j - i < 3
                if (s.charAt(i) == s.charAt(j)
                    && (j - i < 3 || dp[i + 1][j - 1] == true)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
                
                // 如果這次的true比之前的長 --> 更新
                if (dp[i][j] == true && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}