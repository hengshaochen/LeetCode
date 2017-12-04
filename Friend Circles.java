class Solution {
    class UF {
        int[] f;
        
        public UF(int size) {
            f = new int[size];
            for (int i = 0; i < size; i++) {
                f[i] = -1;
            }
        }
        
        // 找父親的數值(不是負號的那個). 沿著f[]一直向上找, 並進行路徑壓縮
        public int find(int x) {
            if (f[x] < 0) {
                return x;
            }
            f[x] = find(f[x]);
            // 如果此node不為父親, 往上面找
            return f[x];
        }
        
        public void union(int x, int y) {
            int root_of_x = find(x);
            int root_of_y = find(y);
            
            if (f[root_of_x] < f[root_of_y]) {
                f[root_of_x] = f[root_of_x] + f[root_of_y];
                f[root_of_y] = root_of_x;
            } else {
                f[root_of_y] = f[root_of_x] + f[root_of_y];
                f[root_of_x] = root_of_y;
            }
        }
    }
    public int findCircleNum(int[][] M) {
        // 用Union-Find, 如果矩陣中數字為1就Union, 例如3*3的話, 第一行 Union(A,B) Union(A,C) , 第二行Union(B,C)
        // 最後掃一次Union的Array, 看有幾個負就是有幾個Set
        UF uf = new UF(M.length);
        
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    uf.union(i, j);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < uf.f.length; i++) {
            if (uf.f[i] < 0) {
                count++;
            }
        }
        return count;
    }
}