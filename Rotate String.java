public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // 三部翻轉
        // ex: offset = 3 --> abcd | efg --> dcba gfe --> efg abcd
        if (offset == 0 || str == null || str.length == 0) { return; }
        if (offset > str.length) { offset = offset % str.length; }
        
        rev(0, str.length - offset - 1, str);
        rev(str.length - offset, str.length - 1, str);
        rev(0, str.length - 1, str);
    }
    
    private void rev(int start, int end, char[] str) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}