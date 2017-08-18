class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
     List<List<Integer>> ans = new ArrayList<List<Integer>>();
     //List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> current = new ArrayList<>();
        
        // 將visited tag都設為false
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        
        // 必須先排序, 因為防止[1,2',2'']的[1,2'']的case, 要把相同數黏在一起    
        Arrays.sort(nums);
        
        helper(current, visited, nums);
        return ans;
    }
    private void helper(ArrayList<Integer> current, boolean[] visited, int[] nums) {
        // Recursion Exit: 滿了
        if (current.size() == nums.length) {
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // *若當前數字已經在list中, 則不加入, 和第一題的差異在於：
            // 不能直接用數字的值來判斷, 因為[1,2'] 還是可以變成[1,2',2''']
            // 只是要確認保證這個2是新的2''就可
            if (visited[i]) {
                continue;
            }
            
            // *不能取[1,2''], 必須先取[1,2'], 因為會導致重複
            // 若前一個沒取, 代表跳著取, 這樣必須跳過
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            
            current.add(nums[i]);
            visited[i] = true;
            
            helper(current, visited, nums);
            
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
