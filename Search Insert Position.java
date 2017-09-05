class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums == null) { return 0;}
        // Case1: 如果存在則返回index
        // Case2: 如果不存在, 則回傳：對應的index
        // 2.a: 在array中可插入
        // 2.b: 要插入在array的尾端
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            } else if (i == nums.length - 1 && nums[i] < target){
                return i + 1;
            }
        }
        return 0;
    }
}