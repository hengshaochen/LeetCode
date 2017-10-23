public class Solution {
    /**
     * @param rooms m x n 2D grid
     * @return nothing
     */
     
    class coord {
        int x, y;
        
        coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) { return; }
        // 求INF到0的最近距離
        // 多個0當作起點做BFS
        // 增加一個超級原始點(dummy), 超級原始點連接每一個0的起點
        // 等同於將多點 最短路問題 轉成 單起點最短路問題
        // 增加方式：原本第一次是只加入原點到queue, 現在加入所有0的一次加入queue
        int row = rooms.length;
        int col = rooms[0].length;
        
        Queue<coord> q = new LinkedList<>();
        // put all 0 in queue: dummy original point
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new coord(i, j));
                }
            }
        }
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            int qsize = q.size();
            
            for (int i = 0; i < qsize; i++) {
                coord cur = q.remove();
                for (int j = 0; j < 4; j++) {
                    coord neighbor = new coord(cur.x + dx[j], cur.y + dy[j]);
                    if (outofBound(rooms, neighbor.x, neighbor.y)) {
                        continue;
                    }
                    
                    if (rooms[neighbor.x][neighbor.y] == Integer.MAX_VALUE) {
                        q.add(neighbor);
                        rooms[neighbor.x][neighbor.y] = rooms[cur.x][cur.y] + 1;
                    }
                }
            }
        }
        
    }
    
    public boolean outofBound(int[][] rooms, int x, int y) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) {
            return true;
        }
        return false;
    }
}