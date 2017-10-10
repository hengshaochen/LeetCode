public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, long n) {
        if (x == 0 || x == 1 || n == 1) {
            return x;
        }
        if (n == 0) {
            return 1.0;
        }
        
        // 負數的情況
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        double ans = 1.0;
        
        double sub = myPow(x, n / 2);   // 分治
        if (n % 2 == 0) {
            ans = sub * sub;
        } else {
            ans = sub * sub * x;
        }
        
        return ans;
    }
}