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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Root job? 如果p或q其中一個等於root, 回傳root本身 / 如果左右子樹都有東西, LCA就是root本身 / 

        // 不能使用root.val == p.val 萬一p有重複元素會錯
        if (root == null ||root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
        
    }
}