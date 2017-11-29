class Solution {
    public List<Integer> lexicalOrder(int n) {
        // 法1. 把所有int轉成String, 接著sort比較 --> 超時 O(n + nlogn + n)
        String[] str = new String[n];
        for (int i = 1; i <= n; i++) {
            // Integer to String
            str[i - 1] = String.valueOf(i);
        }
        
        Arrays.sort(str);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            // String to Integer
            ans.add(Integer.parseInt(str[i]));
        }
        
        return ans;
    }
}

// 法2: 用DFS(前序)建立樹, 同時對樹做Prefix Traverse
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        // 法2: 用DFS(前序)建立樹, 同時對樹做Prefix Traverse
        // 樹要是1 --next level--> 10 ~ 19 --next level--> 100 ~ 199 / 2 --next level--> 20 ~ 29 / 3 --next level--> 30 ~ 39
        for (int i  = 1; i < 10; i++) {
            dfs(i, n, ans);
        }
        
        return ans;
    }
    
    void dfs(int cur_number, int n, List<Integer> ans) {
        if (cur_number > n) {
            return;
        }
        
        ans.add(cur_number);
        
        for (int i = 0; i < 10; i++) {
            dfs(10 * cur_number + i, n, ans);
        }
    }
}
