public class Solution {
    /*
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        String ans = "";
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 ; i--, j--) {
            int sum = carry;
            
            // sum = sum + (i >= 0) ? num1.charAt(i) - '0' : 0; Compiler Error
            sum = sum +( (i >= 0) ? num1.charAt(i) - '0' : 0 );
            sum += (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            ans = (sum % 10) + ans;
            carry = sum / 10;
        }
        // 如果最頭有進位
        if (carry > 0) {
            ans = carry + ans;
        }
        return ans;
    }
}