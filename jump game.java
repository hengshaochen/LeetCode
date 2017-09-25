public class Solution {
    public boolean canJump(int[] A) {
        boolean[] x = new boolean[A.length];
        // 定義 x[i] 為從起點是否能走到i
        
        // init
        x[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                // 第j個要為可以到達的路徑, 如果從起點不可到達j, 他更不可能到更後面
                if (x[j] == true && j + A[j] >= i) {
                    x[i] = true;
                    break;
                }
            }
        }
        return x[A.length - 1];
    }
}