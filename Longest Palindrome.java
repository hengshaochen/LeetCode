public class Solution {
    /*
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) { return 0; }
        // Step1: Count the char repeat time
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        // Step2: repeat times == even --> add the repeat times to total
        // repeat times == odd --> add the (repeat times - 1) to total 
        // if map contain odd, total count + 1 ex: aabccc --> cabac or cacac
        // 思路：把奇數個都-1變成偶數, 把結果+1 (拿一個奇數的當中間的)
        int total = 0;
        boolean odd = false;
        for (Integer i : map.values()) {
            if (i % 2 == 0) {
                total += i;
            } else if (i % 2 == 1) {
                odd = true;
                total += (i - 1);
            }
        }
        
        if (odd == true) {
            total += 1;
        }
        return total;
    }
}