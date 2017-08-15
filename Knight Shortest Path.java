/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 ) { return -1; }
        Queue<Point> q = new LinkedList<>();
        q.add(source);
        
        int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
        int path = 0;
 
        while (!q.isEmpty()) {
            path += 1;
            int currentQSize = q.size();
            for (int i = 0; i < currentQSize; i++) {
                Point currentNode = q.remove();
                for (int j = 0; j < 8; j++) {
                    int neighborX = currentNode.x + deltaX[j];
                    int neighborY = currentNode.y + deltaY[j];
                    
                    // 檢查是否越界, 越界則跳過
                    if (outOfBoundary(grid, neighborX, neighborY)) {
                        continue;
                    }
                    // 如果遇到答案 --> 直接return
                    if (neighborX == destination.x && neighborY == destination.y) {
                        return path;
                    }
                    // 如果遇到FALSE --> 變成TRUE
                    if (grid[neighborX][neighborY] == false) {
                        grid[neighborX][neighborY] = true;
                        q.add(new Point(neighborX, neighborY));
                    }
                    // 如果遇到BARRIER --> 不做事
                }
            }
        }
        return -1;
    }
    // outOfBoundary = true代表越界
    private boolean outOfBoundary(boolean[][] grid, int i, int j) {
        return j < 0 || j >= grid[0].length || i < 0 || i >= grid.length;
    }
}