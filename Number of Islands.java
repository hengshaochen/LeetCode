class Coordinate {
    int i, j;
    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0) { return 0; }
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == true) {
                    BFS(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
    private void BFS(boolean[][] grid, int i, int j) {
        // 右, 下, 上, 左
        int[] directionI = {0, 1, -1, 0};
        int[] directionJ = {1, 0, 0, -1};
        
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(i, j));
        grid[i][j] = false;

        while (!q.isEmpty()) {
            Coordinate current = q.remove();
            // 如果相鄰的四個點為1, 設為0, 放到queue中
            for (int k = 0 ; k < 4 ; k++) {
                int neighborI = current.i + directionI[k];
                int neighborJ = current.j + directionJ[k];
                // 檢查是否越界, 越界則跳過
                if (outOfBoundary(grid, neighborI, neighborJ)) {
                    continue;
                }
                // 若鄰居為沒走訪過且為陸地, 灌水讓他變false
                if (grid[neighborI][neighborJ] == true) {
                    grid[neighborI][neighborJ] = false;
                    q.add(new Coordinate(neighborI, neighborJ));
                }
            }
        }
    }
    // outOfBoundary = true代表越界
    private boolean outOfBoundary(boolean[][] grid, int i, int j) {
        return j < 0 || j >= grid[0].length || i < 0 || i >= grid.length;
    }
}