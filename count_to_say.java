public class Solution {
    public String countAndSay(int n) {
        String current = "1";
        StringBuilder next = new StringBuilder();       
        for (int i = 1; i < n; i++) {
            int count = 1;
            for (int j=0; j < current.length(); j++) {
                // 目前跟下一個重複 --> 繼續累加
                if (j + 1 < current.length() && current.charAt(j) == current.charAt(j+1)) {
                    count = count + 1;
                }
                // 目前跟下一個不重複 --> 輸出, count歸1
                else if (j + 1 < current.length() && current.charAt(j) != current.charAt(j+1)) {
                    next.append(Integer.toString(count) + current.charAt(j));
                    count = 1;
                }
                // 到string尾巴 --> 輸出
                else if (j + 1 == current.length()) {
                    next.append(Integer.toString(count) + current.charAt(j));
                }
            }
            current = next.toString();
            next.setLength(0); // 清空stringBuilder.
        }
        return current;
    }
}