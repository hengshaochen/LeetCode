public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || 
            obstacleGrid[0].length == 0) { return 0; }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] x = new int[row][column];
        
        // init
        if (obstacleGrid[0][0] == 1) {
            x[0][0] = 0;
        } else {
            x[0][0] = 1;
        }
        
        // 如果obstacleGrid為0 且 他的上面一個為1 --> 初始化為1
        // （若他的上面有障礙物, 初始化為0）
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0 && x[i - 1][0] == 1) {
                x[i][0] = 1;
            } else {
                x[i][0] = 0;
            }
        }
        // 如果obstacleGrid為0 且 他的左邊一個為1 --> 初始化為1
        // （若他的左邊有障礙物, 初始化為0）
        for (int i = 1; i < column; i++) {
            if (obstacleGrid[0][i] == 0 && x[0][i - 1] == 1) {
                x[0][i] = 1;
            } else {
                x[0][i] = 0;
            }
        }
        
        // DP: 定義x[i][j] 代表從左上到i,j的可能性
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 0) {
                    x[i][j] = x[i - 1][j] + x[i][j - 1];
                } else {
                    x[i][j] = 0;
                }
            }
        }
        
        return x[row - 1][column - 1];
    }
}