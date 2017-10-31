public class Solution {
    /*
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
     List<String> ans = new ArrayList<>();
    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) { return ans; }
        dfs(0, digits.length(), "", digits);
        return ans;
    }
    
    public void dfs(int cur_index, int total_len, String cur, String digits) {
        if (cur_index == total_len) {
            ans.add(cur);
            return;
        }
        int cur_number = digits.charAt(cur_index) - '0';
        
        for (int i = 0; i < map[cur_number].length(); i++) {
            dfs(cur_index + 1, total_len, cur + map[cur_number].charAt(i), digits);
        }
    }
}