// 失敗版本
public class Solution {
    /*
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        String ans = "";
        int ans_length = Integer.MAX_VALUE;
        if (source.length() < target.length()) { return ans; }
        // 用HashMap統計target每個元素出現次數
        // 另一個HashMap統計現在windows範圍的的元素個數
        // 用first, last指向當前window的頭跟尾
        HashMap<Character, Integer> t_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();
        
        // 統計t_map
        t_map = countMap(target);
        
        int first = 0, last = 0;
        
        s_map.put(source.charAt(0), 1);
        
        // 每回合把當前last加入到s_map, 統計當前first和last的範圍(包含)的各個字母出現次數.
        // 如果發現s_map擁有或超過了t_map的數量, 則可以嘗試盡量將first往右邊移動
        // 如果s_map有元素數量 < t_map, last向右邊移動
        while (last < source.length()) {
            String debug = source.substring(first, last + 1); //debug
            System.out.println(debug);
            if (compareMap(s_map, t_map) == true) {
                String new_ans = source.substring(first, last + 1);
                System.out.println("newans:::" + new_ans);
                if (new_ans.length() < ans_length) {
                    ans = new_ans;
                    ans_length = new_ans.length();
                }
                
                char remove_element = source.charAt(first);
                s_map.put(remove_element, s_map.get(remove_element) - 1);
                if (compareMap(s_map, t_map) == true) {
                    first++;
                } else {
                    s_map.put(remove_element, s_map.get(remove_element) + 1);
                    
                    if (++last >= source.length()) { break; }
                    char cur = source.charAt(++last);
                    if (!s_map.containsKey(cur)) {
                        s_map.put(cur, 1);
                    } else {
                        s_map.put(cur, s_map.get(cur) + 1);
                    }
                }
            } else {
                char cur = source.charAt(++last);
                if (!s_map.containsKey(cur)) {
                    s_map.put(cur, 1);
                } else {
                    s_map.put(cur, s_map.get(cur) + 1);
                }
            }
            
        }
        return ans;
    }
    
    public HashMap<Character, Integer> countMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        
        return map;
    }
    
    // t_map有出現的字母都必須比s_map相等或小, 若成立則傳true, 不然傳false
    public boolean compareMap(HashMap<Character, Integer> s_map, HashMap<Character, Integer> t_map) {
        boolean tag = true;
        for (char cur : t_map.keySet()) {
            // t_map有, s_map從沒出現過, tag = false, 如果沒這判斷下面取intValue, 會Null Ptr Exception
            if (t_map.get(cur) != 0 && s_map.get(cur) == null) {
                tag = false;
                break;
            }
            
            // t_map有, t_map的數量比s_map還多
            if (t_map.get(cur) != 0 && t_map.get(cur).intValue() > s_map.get(cur).intValue()) {
                tag = false;
                break;
            }
        }
        return tag;
    }
}

// 標準答案
public class Solution {

    // i, j指標記錄當前source的window
    // s_map記錄i~j(不包含j)範圍內的各個符號數量
    // t_map記錄target的各個符號數量
    public String minWindow(String source , String target) {
        String ans = "";
        int ans_length = Integer.MAX_VALUE;
        int[] s_map = new int[256];
        int[] t_map = new int[256];
        
        // init t_map
        for (int i = 0; i < target.length(); i++) {
            t_map[target.charAt(i)]++;
        }
        
        // 兩個指標i與j, 若不合法, j向右移動.
        // i向右移動, 因為希望確定有一個合法後, 開始把i向右移動, 嘗試讓他更短
        int i = 0, j = 0;
        while (i < source.length()) {
            // 不合法, j向右移動, 注意：不能移動超過邊界
            while (!compareMap(s_map, t_map) && j < source.length()) {
                s_map[source.charAt(j)]++;
                j++;
            }
            // 若合法, 看看是否比當前最小值還小
            if (compareMap(s_map, t_map)) {
                if (ans_length > j - i) {
                    ans = source.substring(i, j);
                    ans_length = j - i;
                }
            }
            
            // i向右移動
            s_map[source.charAt(i)]--;
            i++;
        }
        
        return ans;
    }
    
    // 比較兩個map, 若t_map有任何符號的數量 > s_map --> return false
    public boolean compareMap(int[] s_map, int[] t_map) {
        for (int i = 0; i < 256; i++) {
            if (t_map[i] > s_map[i]) {
                return false;
            }
        }
        return true;
    }
}