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
        grid[source.x][source.y] = true;
        
        // 記錄BFS的路徑 HashMap<key, value> = <本身節點, 父親節點>
        HashMap<Point, Point> map = new HashMap<>();
        map.put(new Point(0, 0), new Point(-1, -1));
        
        int[] deltaX = {0, 1, -1, 0};
        int[] deltaY = {1, 0, 0, -1};
        
        int path = 0;
 
        while (!q.isEmpty()) {
            path += 1;
            int currentQSize = q.size();
            for (int i = 0; i < currentQSize; i++) {
                Point currentNode = q.remove();
                for (int j = 0; j < 4; j++) {
                    int neighborX = currentNode.x + deltaX[j];
                    int neighborY = currentNode.y + deltaY[j];
                    
                    // 檢查是否越界, 越界則跳過
                    if (outOfBoundary(grid, neighborX, neighborY)) {
                        continue;
                    }
                    // 如果遇到答案 --> 直接return
                    if (neighborX == destination.x && neighborY == destination.y) {
                        
                        map.put(new Point(neighborX, neighborY), new Point(currentNode.x, currentNode.y));
                        
                        printPath(map, source, destination);
                        return path;
                    }
                    // 如果遇到FALSE --> 變成TRUE
                    if (grid[neighborX][neighborY] == false) {
                        grid[neighborX][neighborY] = true;
                        
                        map.put(new Point(neighborX, neighborY), new Point(currentNode.x, currentNode.y));
                        
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
    
    private void printPath(HashMap<Point, Point> map, Point source, Point destination) {
        Point target = new Point(destination.x, destination.y);
        while (target.x != source.x || target.y != source.y) {
            System.out.println(target.x + ", " + target.y);
            
            for (Point p : map.keySet()) {
                if (p.x == target.x && p.y == target.y) {
                    Point buf = new Point(map.get(p).x, map.get(p).y);
                    target.x = buf.x;
                    target.y = buf.y;
                    break;
                }   
            }
        }
        System.out.println(source.x + ", " + source.y);
    }
}