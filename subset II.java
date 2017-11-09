class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        dfs(0, nums, cur, ans);
        return ans;
    }
    
    void dfs(int start, int[] nums, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(cur));
        
        for (int i = start; i < nums.length; i++) {
            // [1,2,2'] 不能選1,2'
            if (i >= 1 && nums[i] == nums[i - 1] && i != start) {
                continue;
            }
            
            cur.add(nums[i]);
            dfs(i + 1, nums, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}