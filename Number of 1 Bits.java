public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        // 法1: 用位運算的 A & (A - 1) 去除最右邊的1, 去除到整個數字為0就結束
        while (n != 0) {
            n = n & n - 1;
            count += 1;
        }
        return count;
        // 法2: 用 A & ( 1 << x ) 檢查第x位是否為1
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*
        int count = 0;
        // 法1: 用位運算的 A & (A - 1) 去除最右邊的1, 去除到整個數字為0就結束
        while (n != 0) {
            n = n & n - 1;
            count += 1;
        }
        return count;
        */
        // 法2: 用 A & ( 1 << x ) 檢查第x位是否為1, 注意：不為1, &出來的結果是2^該位數, 所以條件要寫成!= 0, 不是寫成            == 1
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count += 1;
            }
        }
        return count;
    }
}