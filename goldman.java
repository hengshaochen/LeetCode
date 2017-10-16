// 1.

// 2.

// 3.
class Solution {
    public int climbStairs(int n) {
        // f[n] = f[n-1] + f[n-2]
        // f[0] = 1, f[1] = 1
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }
        
        return f[n];
    }
}

// 4. K-select

// 5.
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

// 6.
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!smap.containsKey(s.charAt(i))) {
                smap.put(s.charAt(i), 1);
            } else {
                smap.put(s.charAt(i), smap.get(s.charAt(i)) +1);
            }
            
            if (!tmap.containsKey(t.charAt(i))) {
                tmap.put(t.charAt(i), 1);
            } else {
                tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
            }
        }
        
        for (Character cur : smap.keySet()) {
            if (tmap.get(cur) == null || smap.get(cur).intValue() != tmap.get(cur).intValue()) {   // 記得改成intValue()
                return false;
            }
        }
        
        return true;
    }
}

// 7.

// 8.

// 9.
class Main {
    public static void main(String[] args) {
        String s = "cccccaaabbb";
        String ans = "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1); 
            } else {
                map.put(cur, 1);
            }
        }
        /*
        for (Character cur : map.keySet()) {
            ans = ans + cur + map.get(cur);
        }
        */
        for (Map.Entry<Character, Integer> cur : map.entrySet()) {
            ans = ans + cur.getKey() + cur.getValue();
        }
        
        System.out.println(ans);
    }
}

// 10.
public class Solution {
    public String reverseWords(String s) {
        String ans = "";
        
        String[] sp = s.split(" ");
        for (int i = sp.length - 1; i >= 0; i--) {
            if (!sp[i].equals("")) {
                ans = ans + ' ' + sp[i];
            }
        }
        
        if (ans.length() == 0) { 
            return ans; 
        }
        return ans.substring(1, ans.length());
    }
}