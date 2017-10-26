public class Solution {
    /*
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans_array = new int[l1 + l2 + 1];
        // 一股腦乘(不管進位)
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                ans_array[i + j] += (num1.charAt(l1 - 1 - i) - '0') * (num2.charAt(l2 - 1 - j) - '0');
            }
        }
        
        // 處理進位
        for (int i = 0; i < l1 + l2; i++) {
            ans_array[i + 1] += ans_array[i] / 10;
            ans_array[i] %= 10;
        }
        
        // 把前導0去掉後, 把array to string
        int bit = l1 + l2;
        while (ans_array[bit] == 0 && bit >= 1) {
            bit--;
        }
        
        String ans = "";
        for (int i = bit; i >= 0; i--) {
            ans += ans_array[i];
        }
        
        return ans;
    }
}