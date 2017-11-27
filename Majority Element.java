// Time: O(n) Space: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int i = 0, max = 1, cur = 1, idx = 0;
        while (i < nums.length) {
            // 如果不是最後一個 或是相等 --> 繼續cur++
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                cur++;
            } else {
                // 如果是最後一個數字, 比較大小更新max
                if (max < cur) {
                    max = cur;
                    idx = i;
                }
                cur = 1;
            }
            i++;
        }
        return nums[idx];
    }
}

// Time: O(n) Space: O(n)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int  i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int max = 1;
        int majorElement = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                majorElement = entry.getKey();
            }
        }
        return majorElement;
    }
}