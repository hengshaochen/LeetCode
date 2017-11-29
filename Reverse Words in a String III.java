public class Solution {
    public String reverseWords(String s) {
        char[] rev = s.toCharArray();
        // 個別一個字母一個字母翻轉
        int start = 0;
        int end = 0;
        while (end < rev.length) {
            // start確認不為空, end找空格的位置
            while (start < rev.length && rev[start] == ' ') {
                start++;
            }
            end = start;
            
            while (end < rev.length && rev[end] != ' ') {
                end++;
            }
            reverse(start, end - 1, rev);
            start = end + 1;
        }
        return new String(rev);
    }
    
    void reverse(int start, int end, char[] input) {
        while (start < end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }
}