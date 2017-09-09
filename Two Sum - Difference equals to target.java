public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
class Pair {
    public int idx, num;
    public Pair(int i, int n) {
        this.idx = i;
        this.num = n;
    }
}
    public int[] twoSum7(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) { return result; }

        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; ++i)
            pairs[i] = new Pair(i, nums[i]);

        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.num - p2.num;
            } 
        });
        
        int left = 0, right = 1;
        while (left <= right) {
            if (left == right) {
                right++;
            }
            
            if ( pairs[right].num - pairs[left].num == Math.abs(target)) {
                result[0] = pairs[left].idx + 1;
                result[1] = pairs[right].idx + 1;
                if (result[0] > result[1]) {
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                return result;
            }
            if (pairs[right].num - pairs[left].num < Math.abs(target)) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }
}