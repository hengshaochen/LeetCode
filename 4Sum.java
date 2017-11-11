public class Solution {
    /*
     * @param numbers: Give an ay
     * @param target: An integer
     * @return: Find all unique quadruplets in the numbersay which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // a + b + c + d = s
        Arrays.sort(numbers);
        List<List<Integer>> ans = new ArrayList<>();
        
        //   i j l r
        // 0 1 2 3 4
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
          for (int j = i + 1; j < numbers.length - 2; j++) {
              if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                continue;
            }
            int left = j + 1;
            int right = numbers.length - 1;
            while (left < right) {
              int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
              if (sum == target) {
                List<Integer> cur = new ArrayList<>();
                cur.add(numbers[i]);
                cur.add(numbers[j]);
                cur.add(numbers[left]);
                cur.add(numbers[right]);
                ans.add(cur);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
              } else if (sum > target) {
                right--;
              } else {
                left++;
              }
            }
            
          }
        }
        return ans;
    }
}