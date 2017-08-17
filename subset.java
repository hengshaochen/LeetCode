class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<Integer> current = new ArrayList<>();
        int startIndex = 0;
        Arrays.sort(nums);
        helper(current, startIndex, nums);
        return ans;
    }
    private void helper(ArrayList<Integer> current, int startIndex, int[] nums) {
        ans.add(new ArrayList<Integer>(current));
        for (int i = startIndex; i < nums.length; i++) {
            current.add(nums[i]);
            helper(current, i + 1, nums);
            current.remove(current.size() - 1);
        }
    }
}