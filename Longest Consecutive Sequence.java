// O(n) HashSet
public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < num.length; i++) {
            if (set.contains(num[i])) {
                set.remove(num[i]);
                int pre = num[i] - 1;
                int next = num[i] + 1;
                
                while (set.contains(pre)) {
                    set.remove(pre);
                    pre--;
                }
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                }
                
                ans = Math.max(ans, next - pre - 1);
            }
        }
        return ans;
    }
}

// O(nlogn) Sorting
public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num.length == 0 || num == null) { return 0; }
        Arrays.sort(num);
        
        int ans = 1;
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] + 1 == num[i]) {
                count++;
                ans = Math.max(count, ans);
            } else if (num[i - 1] == num[i]) {
                // [0,1,1,2] 當num[2]時候數字為1, 這時不要歸零, 但也不要加count
                continue;
            } else {
                count = 1;
            }
        }
        return ans;
    }
}