public class Solution {
    /*
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
     
    public int shortestPath2(boolean[][] grid) {
        // BFS
        int row = grid.length;
        int column = grid[0].length;
        
        Point start = new Point(0, 0);
        Point end = new Point(row - 1, column - 1);
        
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        
        int[] deltaX = {1, -1, 2, -2};
        int[] deltaY = {2, 2, 1, 1};
        
        int step = 0;
        
        while (!q.isEmpty()) {
            step++;
            int qSize = q.size();
            
            for (int i = 0; i < qSize; i++) {
                Point cur = q.remove();
                if (cur.x == end.x && cur.y == end.y) {
                    return step - 1;
                }
                
                for (int j = 0; j < 4; j++) {
                    Point neighbor = new Point(cur.x + deltaX[j], cur.y + deltaY[j]);
                    
                    if (outBoundary(neighbor, grid)) {
                        continue;
                    }
                    
                    // 必須是沒走過, 且不是barrier
                    if (grid[neighbor.x][neighbor.y] == false) {
                        q.add(neighbor);
                        grid[neighbor.x][neighbor.y] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    

    
    boolean outBoundary(Point neighbor, boolean[][] grid) {
        if (neighbor.x >= grid.length || neighbor.x < 0 || neighbor.y >= grid[0].length || neighbor.y < 0) {
            return true;
        }
        return false;
    }
    
}