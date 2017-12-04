import java.util.*;

public class Solution {
    
    public static void main(String args[]) {
        new Solution();
    }
    public Solution() {
        System.out.println(removeDup("abded"));
    }
    
    String removeDup(String s) {
    // abded --> abe
    // a 1
    // b 1
    // d 2
    // e 1
        HashMap<Character, Integer> map = new HashMap<>();
        
        // count the repeat time of each char
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        
        // append to new string
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                ans = ans + s.charAt(i);
            }
        }
        return ans;
    }
}

// Use array as a hashmap
import java.util.*;

public class Solution {
    
    public static void main(String args[]) {
        new Solution();
    }
    public Solution() {
        System.out.println(removeDup("abded"));
    }
    
    String removeDup(String s) {
    // abded --> abe
    // a 1
    // b 1
    // d 2
    // e 1
        int[] map = new int[256];
        
        // count the repeat time of each char
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] = map[s.charAt(i)] + 1;
        }
        
        // append to new string
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) {
                ans = ans + s.charAt(i);
            }
        }
        return ans;
    }
}
