public class Solution {

    List<String> ans = new ArrayList<>();
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) { 
            addInterval(nums, (long)lower, (long)upper);
            return ans;
        }
        
        // 處理頭
        addInterval(nums, (long)lower, (long)nums[0] - 1);
        
        // 處理中間
        for (int i = 1; i < nums.length; i++) {
            addInterval(nums, (long)nums[i - 1] + 1, (long)nums[i] - 1);
        }
        
        // 處理尾
        addInterval(nums, (long)nums[nums.length - 1] + 1, upper);
        
        return ans;
    }
    
    public void addInterval(int[] nums, long start, long end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            ans.add(String.valueOf(start));
        }
        if (start < end) {
            ans.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
    }
}