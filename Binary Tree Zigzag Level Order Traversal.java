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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) { return ans; }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level_count = 0;
        
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            
            level_count += 1;
            int qSize = q.size();
            
            for (int i = 0; i < qSize; i++) {
                TreeNode cur_node = q.remove();
                if (level_count % 2 == 0) {
                    level.add(0, cur_node.val);
                } else {
                    level.add(cur_node.val);
                }
                if (cur_node.left != null) { q.add(cur_node.left); }
                if (cur_node.right != null) { q.add(cur_node.right); }
            }
            ans.add(new ArrayList<Integer>(level));
        }
        
        return ans;
    }
}