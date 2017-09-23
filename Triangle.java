// Version1: DFS
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
     public int min = Integer.MAX_VALUE;
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) { return -1; }
        if (triangle[0] == null || triangle[0].length == 0) { return -1; }
        
        DFS(triangle, 0, 0, 0);
        
        return min;
    }
    public void DFS(int[][] triangle, int x, int y, int sum) {
        if (x == triangle.length) {
            if (sum < min) {
                min = sum;
            }
            return;
        }
        DFS(triangle, x + 1, y, triangle[x][y] + sum);
        DFS(triangle, x + 1, y + 1, triangle[x][y] + sum);
    }
}

// Version2: Divide-And-Conquer
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) { return -1; }
        if (triangle[0] == null || triangle[0].length == 0) { return -1; }
        
        return DFS(triangle, 0, 0);
    }
    public int DFS(int[][] triangle, int x, int y) {
        if (x == triangle.length) {
            return 0;
        }
        
        return triangle[x][y] + Math.min(DFS(triangle, x + 1, y), DFS(triangle, x + 1, y + 1));
    }
}

// Version3: Divide-And-Conquer + Memorizaiton
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int[][] hash;
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) { return -1; }
        if (triangle[0] == null || triangle[0].length == 0) { return -1; }
        
        hash = new int[triangle.length][triangle.length];
        // Init Hash Matrix
        for (int[] row : hash) {
            Arrays.fill(row, -1);
        }
        
        return DFS(triangle, 0, 0);
    }
    public int DFS(int[][] triangle, int x, int y) {
        if (x == triangle.length) {
            return 0;
        }
        
        // 不等於-1, 代表先前算過了
        if (hash[x][y] != -1) {
            return hash[x][y];
        } 
        
        hash[x][y] = triangle[x][y] + Math.min(DFS(triangle, x + 1, y), DFS(triangle, x + 1, y + 1));
        return hash[x][y];
    }
}

// Version4: DP: Bottom-Up
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // bottom-up
        if (triangle == null || triangle.length == 0) { return -1; }
        if (triangle[0] == null || triangle[0].length == 0) { return -1; }
        
        int[][] x = new int[triangle.length][triangle.length];
        
        // init
        for (int i = 0; i < triangle.length; i++) {
            x[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }
        
        for (int i = triangle.length - 2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                x[i][j] = triangle[i][j] + Math.min(x[i + 1][j], x[i + 1][j + 1]);
            }
        }
        
        return x[0][0];
    }
}

// Version5: DP: Top-Down
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // top-down
        if (triangle == null || triangle.length == 0) { return -1; }
        if (triangle[0] == null || triangle[0].length == 0) { return -1; }
        
        // 定義x[i][j]為0,0 -> i,j的最短路徑
        int[][] x = new int[triangle.length][triangle.length];
        
        // init
        x[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            x[i][0] = triangle[i][0] + x[i - 1][0];
            x[i][i] = triangle[i][i] + x[i - 1][i - 1];
        }
        
        // DP
        for (int i = 1; i < triangle.length ; i++) {
            for (int j = 1; j < i; j++) {
                x[i][j] = triangle[i][j] + Math.min(x[i - 1][j -1], x[i - 1][j]);
            }
        }
        
        // find the minimum in the last level
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.length; i++) {
            if (x[triangle.length - 1][i] < min) {
                min = x[triangle.length - 1][i];
            }
        }
        return min;
    }
}