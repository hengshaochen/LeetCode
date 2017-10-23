public class Solution {
    /*
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
     List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) { return ans; }
        String[] dig_map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        // 當前str長度, 當前str, 目標長度, input_digits, digits_map
        dfs(0, "", digits.length(), digits, dig_map);
        return ans;
    }
    
    void dfs(int cur_str_len, String str, int target_len, String input_dig, String[] dig_map) {
        if (cur_str_len == target_len) {
            ans.add(str);
            return;
        }
        // 注意：如果直接用charAt()這時取得的數字為char, 會用ASCII Code, 而不是你要的數字, 例如數字2用charAt得到ASCII為50, 因此把它- '0'強轉int
        int cur_digit = input_dig.charAt(cur_str_len) - '0';
        
        // 展開當前digit數字的所有種可能, 並往深處延伸
        // 例如input為23, 第一次進來這個for會展開2有abc, 接著沿著這個基礎往深處走
        for (int i = 0; i < dig_map[cur_digit].length(); i++) {
            dfs(cur_str_len + 1, str + dig_map[cur_digit].charAt(i), target_len, input_dig, dig_map);
        }
    }
};