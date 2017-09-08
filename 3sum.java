public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    List<List<Integer>> total = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] numbers) {
        // 這題相當於由左至右固定一個數, 然後該數以右做two Sum --> O(n^2)
        // 必須先排序
        if (numbers == null || numbers.length == 0) { return total; }
        
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            // 若起頭相同, 則跳過 --> 去重
            // ex:[-1,-1,-1,-1,1,2,2], 當i=0時,找到(-1,-1,2), 而i=1也會重複找到(-1,-1,2), 必須去除
            if (i >= 1 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            twoSum(i + 1, numbers.length - 1, -numbers[i], numbers);
        }
        return total;
    }
    
    private void twoSum(int start, int end, int target, int[] nums) {
        int i = start, j = end;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> current = new ArrayList<>();
                current.add(-target);
                current.add(nums[i]);
                current.add(nums[j]);
                total.add(current);
                i++;
                j--;
                // 去重[-1,-1,-1,-1,1,2,2], 當i = 1, j = 7 獲得答案(-1,-1,2)
                // 但是i = 2, j = 6 也會獲得答案(-1,-1,2), 要把這個答案去除
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
                
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        }
    }
}