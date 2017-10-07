/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 3:39 - 3:43
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) { return ans; }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            int level_max = Integer.MIN_VALUE;
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = q.remove();
                if (cur.val > level_max) {
                    level_max = cur.val;
                }
                
                // 將左右子樹放入Queue
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            ans.add(level_max);
        }
        return ans;
    }
}