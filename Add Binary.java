public class Solution {
    /*
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        String ans = "";
        int al = a.length() - 1;
        int bl = b.length() - 1;
        
        int carry = 0;
        for (int aptr = al, bptr = bl; aptr >=0 || bptr >= 0; aptr--, bptr--) {
            int sum = carry;
            
            sum += (aptr >= 0) ? a.charAt(aptr) - '0': 0;
            sum += (bptr >= 0) ? b.charAt(bptr) - '0': 0;
            
            ans = (sum % 2) + ans;
            carry = sum / 2;
        }
        if (carry != 0) {
            ans = carry + ans;
        }
        return ans;
    }
}