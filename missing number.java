class Solution {
    public int missingNumber(int[] nums) {
        // {0,1,2,3} XOR {0,1,3}
        
        int ans = 0;
        // 0,1,3 length = 3, 要把0 ^ 1 ^ 2 ^ 3
        for (int i = 0; i <= nums.length; i++) {
            ans = ans ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}


// HashSet Space O(n)
class Solution {
    public int missingNumber(int[] nums) {
        // {0,1,2,3} XOR {0,1,3}
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
        }
        
        Iterator it = set.iterator();
        return (int) it.next();
    }
}