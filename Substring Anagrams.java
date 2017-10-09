// TLE版本
public class Solution {
    /*
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Anagrams 代表p的元素個數和s中某個index開始的p長度元素個數相同即是
        List<Integer> ans = new ArrayList<>();
        
        // 統計p的元素個數
        HashMap<Character, Integer> p_map = count(p);
        
        // 掃一遍s, 每次抓p的長度之s.substring, 統計s.substring元素個數是否跟p完全相等
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            // 統計s.substring字母出現次數
            String sub_s = s.substring(i, i + p.length());
            HashMap<Character, Integer> s_map = count(sub_s);
            
            // 逐一比較
            boolean tag = true;
            for (char cur : s_map.keySet()) {
                if ( !p_map.containsKey(cur) || (p_map.containsKey(cur) && s_map.get(cur) != p_map.get(cur))) {
                    tag = false;
                    break;
                }
            }
            if (tag == true) {
                ans.add(i);
            }
        }
        return ans;
    }

    public HashMap<Character, Integer> count(String input) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        return map;
    }
}

// Sliding Windows
public class Solution {
    /*
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Anagrams 代表p的元素個數和s中某個index開始的p長度元素個數相同即是
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || s == null || p.length() == 0 || p == null || s.length() < p.length()) { return ans; }
        
        // 統計p的元素個數
        HashMap<Character, Integer> p_map = count(p);
        
        String sub_s = s.substring(0, p.length());
        HashMap<Character, Integer> s_map = count(sub_s);
        if (compareMap(s_map, p_map)) {
            ans.add(0);
        }
        
        // 掃一遍s, 每次抓p長度之s.substring, 統計s.substring元素個數是否跟p完全相等
        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            
            // sliding window
            char remove_element = s.charAt(i - 1);
            char add_element = s.charAt(i + p.length() - 1);
            s_map.put(remove_element, s_map.get(remove_element) - 1);  
            if (s_map.containsKey(add_element)) {
                s_map.put(add_element, s_map.get(add_element) + 1);  
            } else {
                s_map.put(add_element, 1);  
            }
            
            // 逐一比較
            if (compareMap(s_map, p_map)) {
                ans.add(i);
            }
        }
        
        return ans;
        
    }

    public HashMap<Character, Integer> count(String input) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        return map;
    }
    
    public boolean compareMap(HashMap<Character, Integer> s_map, HashMap<Character, Integer> p_map) {
        boolean tag = true;
        for (char cur : s_map.keySet()) {
            // s_map有, p_map從沒出現過, tag = false, 如果沒這判斷下面取intValue, 會Null Ptr Exception
            if (s_map.get(cur) != 0 && p_map.get(cur) == null) {
                tag = false;
                break;
            }
            
            // s_map有, p_map統計數量跟s_map不同
            if (s_map.get(cur) != 0 && s_map.get(cur).intValue() != p_map.get(cur).intValue()) {
                tag = false;
                break;
            }
        }
        return tag;
    }
}