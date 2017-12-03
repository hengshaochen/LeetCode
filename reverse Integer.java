class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int pre = rev;
            rev = rev * 10;
            // OverFlow
            if (rev / 10 != pre) {
                return 0;
            }
            rev = rev + x % 10;
            x = x / 10;
        }
        return rev;
    }
}