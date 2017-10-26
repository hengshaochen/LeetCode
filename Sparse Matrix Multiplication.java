public class Solution {
    /*
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = B[0].length;
        int t = B.length;
        int[][] C = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < t; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}

// 提前結束的優化
public class Solution {
    /*
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = B[0].length;
        int t = B.length;
        int[][] C = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}


// 預先處理, 把B矩陣中列有0的刪除
public class Solution {
    /**
     * @param A a sparse matrix
     * @param B a sparse matrix
     * @return the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // Write your code here
        int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        int[][] C = new int[n][m];

        List<List<Integer>> val = new ArrayList<>();
        List<List<Integer>> col = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            val.add(new ArrayList<>());
            col.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                if (B[i][j] != 0) {
                    col.get(i).add(j);
                    val.get(i).add(B[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                // 第二層優化
                if (A[i][k] != 0) {
                    // 第三層優化
                    for (int p = 0; p < col.get(k).size(); p++) {
                        int j = col.get(k).get(p);
                        int v = val.get(k).get(p);
                        C[i][j] += A[i][k] * v;
                    }
                }
            }
        }
        return C;
    }
}