// Brute Force
class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            boolean tag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    tag = false;
                    break;
                }
            }
            if (tag == true) {
                ans += 1;
            }
        }
        return ans;
    }
}

// 消去法
class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                ans++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return ans;
    }
}