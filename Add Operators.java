public class Solution {
    /**
     * @param num a string contains only digits 0-9
     * @param target an integer
     * @return return all possibilities
     */
    List<String> ans = new ArrayList<>();
    String num;
    int target;
    public List<String> addOperators(String num, int target) {
    // 法1: DFS求出所有路徑, 寫一個簡易計算機算String的答案, 最後比較是否等於target
    
    // 法2: 加入lastF可以讓他DFS結束後就算出所有答案
        this.num = num;
        this.target = target;
        
        // dfs: 當前長度, 當前字串, 當前sum, 當前lastF, target
        dfs(0, "", 0, 0);
        return ans;
    }
    void dfs(int len, String str, long sum, long lastF) {
        if (len == num.length()) {
            if (sum == target) {
                ans.add(str);
            }
            return;
        }
        
        // 窮舉1或12 或123...
        for (int i = len; i < num.length(); i++) {
            long cur = Long.parseLong(num.substring(len, i + 1));
            
            // len為0不用取+ - *
            if (len == 0) {
                dfs(i + 1, "" + cur, cur, cur);
            } else {
                dfs(i + 1, str + "+" + cur, sum + cur, cur);
                dfs(i + 1, str + "-" + cur, sum - cur, -cur);
                dfs(i + 1, str + "*" + cur, sum - (lastF) + lastF * cur, lastF * cur);
            }
            
            // 如果當前的cur數字是0, 不要變成078這種
            // 例如105中的 1 + 5 不需要輸出, 跑到0的時候不需要窮舉下去
            if (cur == 0) {
                break;
            }
        }
    }
}

// 窮舉加減乘除所有可能性的程式碼
public class Solution {
    /*
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        
        dfs(0, "", num, target);
        return ans;
    }
    
    // start index, string, input num, target number
    void dfs(int start_index, String str, String num, int target) {
        if (start_index == num.length()) {
            ans.add(str);
            return;
        }
        
        for (int i = start_index; i < num.length(); i++) {
            int cur_num = Integer.parseInt(num.substring(start_index, i + 1));
            if (start_index == 0) {
                dfs(i + 1, "" + cur_num, num, target);
            } else {
                dfs(i + 1, str + "+" + cur_num, num, target);
                dfs(i + 1, str + "-" + cur_num, num, target);
                dfs(i + 1, str + "*" + cur_num, num, target);
            }
        }
    }
}