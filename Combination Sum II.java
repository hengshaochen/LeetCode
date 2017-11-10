class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort
        // [1, 1', 2, 5, 6, 7, 10]
        // sum = 3 , [1,2] [1',2] // sum = 4 [1,1',2]
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        
        dfs(0, 0, cur, ans, candidates, target);
        return ans;
    }
    void dfs(int start, int sum, List<Integer> cur, List<List<Integer>> ans, int[] candidates, int target) {
        // Exit
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // aviod [1,2] [1',2] 回到第一層的1, 不能後面又有1, 第一層1: start = 0, i = 1 要continue
             if (i >= 1 && candidates[i] == candidates[i - 1] && i != start) {
                 continue;
             }
            cur.add(candidates[i]);
            sum += candidates[i];
            
            dfs(i + 1, sum, cur, ans, candidates, target);
            
            cur.remove(cur.size() - 1);
            sum -= candidates[i];
        }
    }
}