public class Solution {
    /*
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');
        
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            // 如果左邊的值不在map, 肯定不是mirror, 在map中才有機會mirror
            if (!map.containsKey(num.charAt(left))) {
                return false;
            }
            System.out.println(right);
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}