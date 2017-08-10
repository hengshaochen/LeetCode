public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) { return false; }
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            // Step1: 每次loop比較新來的char有沒有在map中, 若有則不加入, 若沒有則加入map
            if (sMap.get(s.charAt(i)) == null ) { sMap.put(s.charAt(i), i); }
            if (tMap.get(t.charAt(i)) == null ) { tMap.put(t.charAt(i), i); }
            // Step2: 接著使用各自的當前char 去map.get() 找到對應的value, 若兩者相等 則繼續往下, 兩者不相等, 則return false
            if (sMap.get(s.charAt(i)) != tMap.get(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}