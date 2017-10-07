public class Solution {
    public String encode(List<String> strs) {
        String es = "";
        // str.length + "+" + str.context
        for (int i = 0; i < strs.size(); i++) {
            String cur = strs.get(i);
            es = es + cur.length() + "+" + cur;
        }
        return es;
    }
    public List<String> decode(String str) {
        // find first + , left of + is length, right of + to length is cur process string
        // delete the substring from length to end of process string
        // ex: 5+lint+2+bc --> first time: 5+lint second time: 2+bc

        List<String> ans = new ArrayList<>();

        while (str.length() > 0) {
            int first_plus_index = str.indexOf("+");
            int cur_length = Integer.parseInt(str.substring(0, first_plus_index));
            String cur_str = str.substring(first_plus_index + 1, first_plus_index + 1 + cur_length);
            ans.add(cur_str);
            str = str.substring(first_plus_index + 1 + cur_length, str.length() + 1);
        }

        return ans;
    }
}