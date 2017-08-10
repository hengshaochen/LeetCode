public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] splitStr = str.split(" ");
        if (pattern.length() != splitStr.length) { return false; }
        
        // 左映射到右(pattern -> str)
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            // Step1: 每次loop比較新來的char有沒有在map中, 若有則不加入, 若沒有則加入map
            if (map.get(pattern.charAt(i)) == null ) {
                map.put(pattern.charAt(i), splitStr[i]);
            }
            // Step2: 接著使用各自的當前char 去map.get() 找到對應的value, 若兩者相等 則繼續往下, 兩者不相等, 則return false
            //if (map.get(pattern.charAt(i)) != splitStr[i]) { // 因為String是class, 用!=是比較物件地址, 要使用class的function
            if ((map.get(pattern.charAt(i))).compareTo(splitStr[i]) != 0 ) {
                return false;
            }
        }
        
        // 右映射到左(pattern <- str)
        HashMap<String, Character> revMap = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            if (revMap.get(splitStr[i]) == null ) {
                revMap.put(splitStr[i], pattern.charAt(i));
            }
            if ((revMap.get(splitStr[i])).compareTo(pattern.charAt(i)) != 0 ) {
                return false;
            }
        }
        return true;
    }
}