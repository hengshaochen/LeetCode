// 3 Sum without sort --> 會有重複元素
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            
            // two sum
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                List<Integer> local = new ArrayList<>();
                if (map.containsKey(target - nums[j])) {
                    local.add(nums[i]);
                    local.add(nums[map.get(target - nums[j])]);
                    local.add(nums[j]);
                    ans.add(new ArrayList<Integer>(local));
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return ans;
    }
}

// 3 Sum排序後用2ptr
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            // 去重
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, nums.length - 1, target);
        }
        return ans;
    }
    public void twoSum(int[] nums, int start, int end, int target) {
        int i = start;
        int j = end;
        
        while (i < j) {
            List<Integer> local = new ArrayList<>();
            if (nums[i] + nums[j] == target) {
                local.add(-target);
                local.add(nums[i]);
                local.add(nums[j]);
                ans.add(local);
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}