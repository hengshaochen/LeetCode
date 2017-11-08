// DFS + 剪枝 --> MLE , 但是是很好的練習
public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) { return true; }
        
        HashMap<String, Boolean> map = new HashMap<>();
        //boolean ans = false;
        
        // DFS去走訪所有切割方式 + 剪枝
        return dfs(s, dict, map);
        
        //return ans;
    }
    
    boolean dfs(String s, Set<String> dict, HashMap<String, Boolean> map)
    {
        // 已經算過了（在Map中）直接return
        if (map.containsKey(s)) {
            return map.get(s);
        }
        // 如果s在字典中, 答案直接變true, 因為可以左邊切為空集合, 右邊為s
        if (dict.contains(s)) {
            map.put(s, true);
            return true;
        }
        
        // DFS遞回 + 剪枝
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            
            if (dfs(left, dict, map) == true && dict.contains(right)) {
                map.put(s, true);
                return true;
            }
        }
        // 如果s的所有切割方式都不行組成字典中的字
        map.put(s, false);
        return false;
    }
}


// DP: 待研究
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}