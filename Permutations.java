class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
     List<List<Integer>> ans = new ArrayList<List<Integer>>();
     //List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> current = new ArrayList<>();
        helper(current, nums);
        return ans;
    }
    private void helper(ArrayList<Integer> current, int[] nums) {
        // Recursion Exit: 滿了
        if (current.size() == nums.length) {
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 若當前數字已經在current list中, 則不加入
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);
            helper(current, nums);
            current.remove(current.size() - 1);
        }
    }
}
