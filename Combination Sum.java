class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        dfs(0, 0, cur, ans, candidates, target);
        
        return ans;
    }
    
    void dfs(int start, int sum, List<Integer> cur, List<List<Integer>> ans, int[] candidates, int target) {
        // Exit
        if (sum == target) {
            ans.add(new ArrayList<Integer>(cur));
        }
        // 2,3,6,7  , 2222 --> return 
        if (sum > target) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            sum += candidates[i];
            
            dfs(i, sum, cur, ans, candidates, target);
            
            cur.remove(cur.size() - 1);
            sum -= candidates[i];
        }
    }
}