class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(1, k, n, cur, ans);
        return ans;
    }
    
    void dfs(int start, int k, int n, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(i + 1, k, n, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
    
    
}