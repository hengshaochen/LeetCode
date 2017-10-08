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
    boolean ans = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return ans; }
        helper(root.left, root.right);
        return ans;
    }
    public void helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return;
        }
        
        if ((l == null && r != null) || (l != null && r == null)) {
            ans = false;
            return;
        }
        
        if (l.val == r.val) {
            helper(l.left, r.right);
            helper(l.right, r.left);
        } else {
            ans = false;
        }
        
    }
}