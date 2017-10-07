// 失敗版
public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // 如果長度差異 >= 2 --> false
        if (Math.abs(s.length() - t.length()) >= 2) { return false; }
        
        // 想法：先排序, 照ASCII小至大, 逐位比較
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        bubbleSort(sc);
        
        // 如果長度差異為1, 要完全相同
        if (s.length() - t.length() == 1) {
                System.out.println("a");
            int min = Math.min(s.length(), t.length());
            for (int i = 0; i < min; i++) {
                if (sc[i] != tc[i]) {
                    return false;
                }
            }
        }
        
        // 如果長度差異為0, 必須差一位
        int diff = 0;
        if (s.length() - t.length() == 0) {
            System.out.println("b");
            int min = Math.min(s.length(), t.length());
            for (int i = 0; i < min; i++) {
                System.out.println(sc[i] + " " + tc[i]);
                if (sc[i] != tc[i]) {
                    diff += 1;
                }
            }
            if (diff != 1) {
                return false;
            }
        }
        
        return true;
    }
    
}

// 正確版

public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // 把t都設為比較長的
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        int diff = t.length() - s.length();

        if (diff > 1) {
            return false;
        }
        if (diff == 0) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    cnt++;
                }
            }
            if (cnt != 1) {
                return false;
            }
        }
        
        if (diff == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    if ((s.substring(i).equals(t.substring(i + 1))) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
