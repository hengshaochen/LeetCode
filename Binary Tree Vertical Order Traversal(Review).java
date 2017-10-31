/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
     int max = 0; // 為了讓map到時輸出可以照著由小到大輸出
     int min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        // use DFS to label node and put into arraylist
        dfs(root, 0, map);
        
        // traverse map and get the ans
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
    
    void dfs(TreeNode root, int label, HashMap<Integer, ArrayList<Integer>> map) {
        if (root == null) {
            return;
        }
        max = Math.max(max, label);
        min = Math.min(min, label);
        
        if (!map.containsKey(label)) {
            ArrayList<Integer> local = new ArrayList<>();
            local.add(root.val);
            map.put(label, local);
        } else {
            map.get(label).add(root.val);
        }
        
        dfs(root.left, label - 1, map);
        dfs(root.right, label + 1, map);
        
    }
}

// 要用BFS才對, 上面錯誤
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
     int max = 0; // 為了讓map到時輸出可以照著由小到大輸出
     int min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) { return ans; }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // use BFS to garantee 列由上到下, DFS不能保證列從上到下
        q.add(root);
        q2.add(0);
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                TreeNode cur = q.remove();
                int label = q2.remove();
                max = Math.max(max, label);
                min = Math.min(min, label);
                
                if (!map.containsKey(label)) {
                    ArrayList<Integer> local = new ArrayList<>();
                    local.add(cur.val);
                    map.put(label, local);
                } else {
                    map.get(label).add(cur.val);
                }
                
                if (cur.left != null) {
                    q.add(cur.left);
                    q2.add(label - 1);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    q2.add(label + 1);
                }
            }
        }
        
        // traverse map and get the ans
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}