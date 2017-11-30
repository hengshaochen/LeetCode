// Accept
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        int i = 0;
        //for (int i = 0; i < s.length(); i++) {
        while (i < s.length() - 1) {
            // System.out.println(i);
            HashSet<Character> set = new HashSet<>();
            int cur_length = 0;
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    cur_length++;
                    max = Math.max(max, cur_length);
                } else {
                    break;
                }
            }
            i++;
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        int i = 0;
        //for (int i = 0; i < s.length(); i++) {
        while (i < s.length() - 1) {
            // System.out.println(i);
            HashSet<Character> set = new HashSet<>();
            int cur_length = 0;
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    cur_length++;
                    max = Math.max(max, cur_length);
                    i = j;
                } else {
                    i = j;
                    break;
                }
            }
        }
        return max;
    }
}
