public class Solution {
    /*
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        int[][] x = new int[m][n];
        
        // init
        x[0][0] = 0;
        for (int i = 1; i < m; i++) {
            x[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            x[0][i] = 1;
        }
        
        // DP: 定義x[i][j] 代表從左上到i,j的可能性
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                x[i][j] = x[i - 1][j] + x[i][j - 1];
            }
        }
        
        return x[m - 1][n - 1];
    }
}