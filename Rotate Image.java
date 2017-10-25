public class Solution {
    /*
     * @param matrix: a lists of integers
     * @return: 
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // 上下轉
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        
        
        // 沿著對角線轉
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
        }
        /*
        // 如果題目改成逆時針, 則先左右轉再沿著對角線轉
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        */
    }
}