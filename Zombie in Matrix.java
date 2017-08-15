public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
    int PEOPLE = 0;
    int ZOMBIE = 1;
    int WALL = 2;
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0) { return 0; }
        // 先統計people幾個, 並把現有的zombie加入q
        int numP = 0;
        int day = 0;
        Queue<Coordinate> q = new LinkedList<>();
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == PEOPLE) {
                    numP += 1;
                } else if (grid[i][j] == ZOMBIE) {
                    q.add(new Coordinate(i, j));
                }
            }
        }
        // corner case: 當沒有人時
        if (numP == 0) { return 0; }
        
        // 右, 下, 上, 左
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};
        // 針對Q的做BFS
        while (!q.isEmpty()) {
            day += 1;
                //printGrid(grid); 測試用
            //for (int i = 0; i < q.size(); i++) {
            // 上面這種寫法, 因為q.size()會不斷被下面變動, 會導致問題
            int todayQSize = q.size();
            for (int i = 0; i < todayQSize; i++) {
                Coordinate currentNode = q.remove();
                for (int j = 0; j < 4; j++) {
                    int neighborX = currentNode.x + directionX[j];
                    int neighborY = currentNode.y + directionY[j];
                    // 檢查是否越界, 越界則跳過
                    if (outOfBoundary(grid, neighborX, neighborY)) {
                        continue;
                    }
                    // 如果遇到PEOPLE --> 變成ZOMBIE
                    if (grid[neighborX][neighborY] == PEOPLE) {
                        grid[neighborX][neighborY] = ZOMBIE;
                        q.add(new Coordinate(neighborX, neighborY));
                        numP -= 1;
                        if (numP == 0) {
                            return day;
                        }
                    }
                    // 如果遇到WALL --> 不做事
                }
            }
        }
        return -1;
    }
    // outOfBoundary = true代表越界
    private boolean outOfBoundary(int[][] grid, int i, int j) {
        return j < 0 || j >= grid[0].length || i < 0 || i >= grid.length;
    }
    /*
    // 測試用function
    private void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
                System.out.println();
        }
        System.out.println();
    }
    */
}