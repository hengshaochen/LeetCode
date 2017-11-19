class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i > 0 && nums[i + 1] < nums[i - 1]) { 
                    // i + 1太小, 把i + 1改成i
                    nums[i + 1] = nums[i];
                } else {
                    // i太大, 把i改成i + 1
                    nums[i] = nums[i + 1];
                }
            }
        }
        return count <= 1;
    }
}