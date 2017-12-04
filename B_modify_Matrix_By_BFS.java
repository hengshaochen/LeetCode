import java.util.*;
public class Solution {
    
    public static void main(String args[]) {
        new Solution();
    }
    public Solution() {
        char[][] input = { {'O','O','O','X'}, {'X','X','X','X'}, {'X','O','O','X'}, {'X','O','O','X'} };
        Pair start = new Pair(2,1);
        set(input, start);
        
        // print ans
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println("");
        }
    }
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    void set(char[][] map, Pair start) {
        /*
        0[OOOX]
        1[XXXX]
        2[XOOX]  (2,1)
        3[XOOX]
        */
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                Pair cur = q.remove();
                map[cur.x][cur.y] = 'X';
                
                int[] dx = {1, 0, -1, 0};
                int[] dy = {0, 1,  0, -1};
                for (int j = 0; j < 4; j++) {
                    if (outBoundary(cur.x + dx[j], cur.y + dy[j], map)) {
                        continue;
                    }
                    if (map[cur.x + dx[j]][cur.y + dy[j]] == 'O') {
                        q.add(new Pair(cur.x + dx[j], cur.y + dy[j]));
                        map[cur.x + dx[j]][cur.y + dy[j]] = 'X';
                    }
                }
            }
        }
    }
    
    boolean outBoundary(int x, int y, char[][] input) {
        if (x < 0 || y < 0 || x >= input.length || y >= input[0].length) {
            return true;
        }
        return false;
    }
}

