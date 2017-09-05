public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        // <key, value> = <prefixSum, index>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        
        int prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            
            // 如果在map中, 代表prefixSum[j + 1] == prefixSum[i]
            if (map.containsKey(prefixSum)) {
                ans.add(map.get(prefixSum));
                ans.add(i);
                return ans;
            } else {
                map.put(prefixSum, i + 1);
            }
        }
        return ans;
    }
    /*
    private void printMap(HashMap<Integer, Integer> map) {
        for (Integer i : map.values()) {
            System.out.print(i + " ");
        }
    }
    */
}