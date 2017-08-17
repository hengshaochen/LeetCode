public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // 切割問題就是組合問題 N個字母切割問題 --> N-1個數字的組合
        int startIndex = 0;
        ArrayList<String> current = new ArrayList<>();
        helper(current, startIndex, s);
        return ans;
    }
    private void helper(ArrayList<String> current, int startIndex, String s) {
        // 出口
        if (startIndex == s.length()) {
            ans.add(new ArrayList<String>(current));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i+1); // ***
            if (isPalin(subString) == false) {
                continue;
            }
            current.add(subString);
            helper(current, i + 1, s);
            current.remove(current.size() - 1);
        }
        
    }
    private boolean isPalin(String subS) {
        for (int i = 0, j = subS.length() - 1; i < j; i++, j--) {
            if (subS.charAt(i) != subS.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}