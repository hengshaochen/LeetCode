public class Solution {
    /**
     * @param words a set of words without duplicates
     * @return all word squares
     */
     int wordLen;
     Map<String, List<String>> prefix = new HashMap<>();
     List<String> squares = new ArrayList<>();
     List<List<String>> ans = new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        if (words.length == 0) {
            return ans;
        }
        initPrefix(words);
        
        wordLen = words[0].length();
        dfs(0);
        return ans;
    }
    
    void initPrefix(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String cur_word = words[i];
            
            // 放整個字
            if (!prefix.containsKey("")) {
                prefix.put("", new ArrayList<String>());
            }
            prefix.get("").add(cur_word);
            
            String pre = "";
            for (int j = 0; j < cur_word.length(); j++) {
                pre = pre + cur_word.charAt(j);
                if (!prefix.containsKey(pre)) {
                    prefix.put(pre, new ArrayList<String>());
                }
                prefix.get(pre).add(cur_word);
            }
        }
    }
    
    void dfs(int curLen) {
        if (curLen == wordLen) {
            ans.add(new ArrayList<>(squares));
            return;
        }
        
        // 從目前的pre, 搜可能的後續枚舉方式
        String pre = "";    // 計算當前pre
        // 解決冗余1: 第一個填ball, 第二個填area, 則第三個pre要是le開始
        for (int i = 0; i < curLen; i++) {
            pre = pre + squares.get(i).charAt(curLen);
        }
        List<String> next_word = prefix.get(pre);
        
        for (String cur : next_word) {
            // 冗余2: 第一ball, 第二area, 第三只能le, 第四只能la
            if (!checkPrefix(curLen, cur)) {
                continue;
            }
            squares.add(cur);
            dfs(curLen + 1);
            squares.remove(squares.size() - 1);
        }
    }

    boolean checkPrefix(int l, String nextWord) {
        for (int j = l + 1; j < wordLen; j++) {
            String pre = "";
            for (int k = 0; k < l; k++) {
                pre = pre + squares.get(k).charAt(j);
            }
            pre += nextWord.charAt(j);
            if (!prefix.containsKey(pre)) {
                return false;
            }
        }
        return true;
    }

}