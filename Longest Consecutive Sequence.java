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