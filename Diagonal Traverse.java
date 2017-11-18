class Solution {
    class Coord {
        int x;
        int y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) { return new int[0]; }
        int[] ans = new int[matrix.length * matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        int[] init = {0, 0};
        q.add(init);
        visited[0][0] = true;
        
        boolean rev = true;
        int idx = 0;
        while (!q.isEmpty()) {
            int qsize = q.size();
            
            int[] local_ans = new int[qsize];
            for (int i = 0; i < qsize; i++) {
                int[] cur = q.remove();
                local_ans[i] = matrix[cur[0]][cur[1]];
                
                int[] dx = {0, 1};
                int[] dy = {1, 0};
                
                for (int j = 0; j < 2; j++) {
                    int[] neighbor = {cur[0] + dx[j], cur[1] + dy[j]};
                    if (outofBoundary(neighbor, matrix) || visited[neighbor[0]][neighbor[1]] == true) {
                        continue;
                    }
                    q.add(neighbor);
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
            if (rev == false) {
                for (int i = 0; i < qsize; i++) {
                // 不反轉
                    ans[idx + i] = local_ans[i];
                }
                rev = true;
            } else {
                // 要反轉
                for (int i = 0; i < qsize; i++) {
                    ans[idx + i] = local_ans[qsize - i - 1];
                }
                rev = false;
            }
            idx += qsize;
        }
        
        return ans;
    }
    boolean outofBoundary(int[] arr, int[][] input) {
        if (arr[0] < 0 || arr[1] < 0 || arr[0] >= input.length || arr[1] >= input[0].length) {
            return true;
        }
        return false;
    }
}