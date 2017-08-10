public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) { return false; }
        // 左映射到右(s -> t)
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            // Step1: 每次loop比較新來的char有沒有在map中, 若有則不加入, 若沒有則加入map
            if (map.get(s.charAt(i)) == null ) {
                map.put(s.charAt(i), t.charAt(i));
            }
            // Step2: 接著使用各自的當前char 去map.get() 找到對應的value, 若兩者相等 則繼續往下, 兩者不相等, 則return false
            if (map.get(s.charAt(i)) != t.charAt(i) ) {
                return false;
            }
        }
        // 右映射到左(s <- t)
        HashMap<Character, Character> revMap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (revMap.get(t.charAt(i)) == null ) {
                revMap.put(t.charAt(i), s.charAt(i));
            }
            if (revMap.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
/*
錯誤版本, 錯誤原因：

假如java没有缓冲区的话，这个代码一个case都过不了，Integer是类，直接比较是比较地址，两个值相等的Integer地址都不会相等。因为java有缓冲区，对于Integer在-128~127范围内的值直接从缓冲区里取得，所以可以直接进行比较，大于127小于-128的数会直接比较地址。你的代码在比较的时候加上.intValue()取int值就可以过了
一個很長的test case會出錯 , 要掃兩次, 而且不應該使用兩個Map, 使用1個即可, 第二：用數字當value在這題有點奇怪, 應直接使用原本的char當value
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

// 改成以下版本會正確：
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
            if ( (sMap.get(s.charAt(i))).compareTo(tMap.get(t.charAt(i))) != 0) {
                return false;
            }
        }
        return true;
    }
}