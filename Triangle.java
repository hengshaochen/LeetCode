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