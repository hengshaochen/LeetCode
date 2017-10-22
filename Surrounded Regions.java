public class Solution {
    class Coord {
        int x;
        int y;
        
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void surroundedRegions(char[][] board) {
        if (board.length == 0) { return; }
        int row = board.length;
        int col = board[0].length;
        // 從四個方向灌水, 若遇到邊界的O變成W
        for (int i = 0; i < col; i++) {
            bfs(board, 0, i);
            bfs(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            bfs(board, i, 0);
            bfs(board, i, col - 1);
        }
        
        // 遇到W轉成O, 遇到X不動, 遇到O轉成X
        // 因為W是沒有被圍住的區域, 不需要變成X
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    void bfs(char[][] board, int x, int y) {
        // 只需處理O的進行灌水成W
        if (board[x][y] != 'O') {
            return;
        }
        Coord ori = new Coord(x, y);
        Queue<Coord> q = new LinkedList<>();
        q.add(ori);
        
        int[] dx = {0, 1, 0, -1}; 
        int[] dy = {1, 0, -1, 0};
        
       while (!q.isEmpty()) {
           int qsize = q.size();
           for (int i = 0; i < qsize; i++) {
               Coord cur = q.remove();
               board[cur.x][cur.y] = 'W';
               
               for (int j = 0; j < 4; j++) {
                    if (outOfBoundary(board, cur.x + dx[j], cur.y + dy[j])) {
                        continue;
                    }
                    if (board[cur.x + dx[j]][cur.y + dy[j]] == 'O') {
                        q.add(new Coord(cur.x + dx[j], cur.y + dy[j]));
                    }
               }
           }
       }
        
    }
    private boolean outOfBoundary(char[][] board, int i, int j) {
        return j < 0 || j >= board[0].length || i < 0 || i >= board.length;
    }
}