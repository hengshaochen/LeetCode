class Solution {
    public int firstUniqChar(String s) {
        // use hashmap, scan 1 times
        //HashMap<Character, Integer> map = new HashMap<>();
        int[] map = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] += 1;
        }
        
        // scan again, and get the cur char value in map 
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) {
                return i;
            }    
        }
        
        return -1;
    }
}