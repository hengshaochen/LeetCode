public class Solution {
    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) { return -1; }
        // Step1: put in hashmap<Character, Boolean>
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), true);
            } else {
                map.put(s.charAt(i), false);
            }
        }
        
        // Step2: scan the map and return the first non-duplicate character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == false) {
                return i;
            }
        }
        return -1;
    }
}


// Version2: double for-loop
public class Solution {
    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) { return -1; }
        // Use two pointer
        //int i = 0, j = 1;
        for (int i = 0; i < s.length(); i++) {
            boolean tag = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && i != j) {
                    tag = false;
                    break;
                }
            }
            if (tag == true) {
                return i;
            }
        }
        return -1;
    }
}