public class Solution {
    /**
     * @param n an integer
     * @return a list of combination
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        //if (n == 1) { return ans; }
        
        // 起始點, 因為要排序, 下一層dfs的是從上一層dfs的除數為基礎再上去找
        // remain, 剩餘的被除數
        dfs(2, n);
        
        return ans;
    }
    
    void dfs(int start, int remain) {
        // cur.size() > 1 是刪除自己本身這種factorization方式
        if (remain == 1) {
            //ans.add(cur);  // 要改成deep copy, 因為這是加入地址進去, 後面cur被改, ans裡面的內容也會不同
            if (cur.size() != 1) {
                ans.add(new ArrayList<Integer>(cur));
            }
            return; // 注意, return不是寫在上面if裡面
        }
        
        // i <= remain / 2 會出錯, 例如分解12 = 2 * 2 * 3, 在remain=3時, 必須再/3, 但如果條件寫<= remain / 2就不會進入迴圈, 不會除以3, 導致remain永遠不會被除到變成1
        for (int i = start; i <= remain; i++) {
            // 防止超時, 去掉不必要的**** 沒這行會TLE
            // 例如12, 12最多跑到i = 6就好, 沒必要跑7-12
            
            if (i > remain / i) {
                break;
            }
            
            
            if (remain % i == 0) {
                cur.add(i);
                dfs(i, remain / i);  // 從i的基礎上繼續往上加
                cur.remove(cur.size() - 1);  // 回朔, 因為用global cur, 傳地址
            }
        }
        cur.add(remain);
        dfs(remain, 1);  // 從i的基礎上繼續往上加
        cur.remove(cur.size() - 1);  // 回朔, 因為用global cur, 傳地址
        
    }
}