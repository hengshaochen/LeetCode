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
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    List<List<Integer>> ans = new ArrayList<>();
    // 用HashMap裝每層的答案, 因為雙層arraylist, 不能一次add某層的一個數字, 要就是一次add一整層arraylist
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        // 特判, 當root == null --> return []
        if (root == null) { return new ArrayList<>(); }
        
        // 一層一層的剝開leaf node
        map.put(1, new ArrayList<Integer>());
        DFS(root);
        
        for (Integer dep : map.keySet()) {
            ans.add(map.get(dep));
        }
        
        return ans;
    }
    
    public int DFS(TreeNode cur) {
        // 注意：若沒有這行, {1,2}這種樹, 1的right為null, 會進行到48行nullptrExec
        if (cur == null) { return 0; }
        
        if (cur.left == null && cur.right == null) {
            map.get(1).add(cur.val);
            return 1;
        }
        
        int left = DFS(cur.left);
        int right = DFS(cur.right);
        
        int depth = Math.max(left, right) + 1;
        
        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayList<Integer>());
        }
        map.get(depth).add(cur.val);
        
        return depth;
    }
}