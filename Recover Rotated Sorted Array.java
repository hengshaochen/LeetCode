public class Solution {
    /*
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // 三步翻轉法
        
        // Step1: 找翻轉點
        int revPoint = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(i + 1 < nums.size() - 1  && nums.get(i) < nums.get(i + 1)) {
                revPoint = i + 1;
            } else {
                revPoint = i + 1;
                break;
            }
        }
        
        // 如果是已經排序好, revPoint會等於nums.size() --> 則不須後續翻轉
        if (revPoint == nums.size() - 1) { return; }
        
        // Step2: 翻轉點以前翻轉
        rev(0, revPoint - 1, nums);
        
        // Step3: 翻轉點(包含)以後翻轉
        rev(revPoint, nums.size() - 1, nums);
        
        // Step4: 整體翻轉
        rev(0, nums.size() - 1, nums);
    }
    
    private void rev(int start, int end, List<Integer> nums) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}