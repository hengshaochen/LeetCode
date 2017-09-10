class Solution {
    public boolean isPalindrome(int x) {
        int xCopy = x;
        int rev = 0;
        
        while (xCopy > 0) {
            rev = rev * 10;
            rev = rev + (xCopy % 10);
            xCopy = xCopy / 10;
        }
        if (rev == x) {
            return true;
        } else {
            return false;
        }
    }
}