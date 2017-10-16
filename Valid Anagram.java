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

// Good Version
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) +1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            // 如果map中沒有t的char, 不要動, 之後掃沒有歸零的就會是false
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        
        for (Character cur : map.keySet()) {
            if (map.get(cur).intValue() != 0) {   // 記得改成intValue()
                return false;
            }
        }
        
        return true;
    }
}