class Solution {
    int ans;
    public int totalNQueens(int n) {
        ans = 0;
        // 記錄當前的選的queen
        List<Integer> status = new ArrayList<>();
        
        // DFS窮舉, 有幾個row就DFS幾層, 窮舉的同時不要窮舉invalid的
        dfs(status, n);
        
        return ans;
    }
    
    void dfs(List<Integer> status, int n) {
        if (status.size() == n) {
            ans++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (!isValid(status, col)) {
                continue;
            }
            status.add(col);
            dfs(status, n);
            status.remove(status.size() - 1);
        }
    }
    
    boolean isValid(List<Integer> status, int col) {
        // (3,2) col = 2,  status.size() = 3
        for (int i = 0; i < status.size(); i++) {
            // 檢查有沒有在同個column
            if (status.get(i) == col) {
                return false;
            }
            
            // 檢查斜角
            // 斜率： dy / dx
            double dx = status.size() - i;
            double dy = col - status.get(i);
            double slope = Math.abs(dy / dx);
            
            if (slope == 1) {
                return false;
            }
        }
        return true;
    }
}