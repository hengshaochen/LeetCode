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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        
        // 這個root要把左右子樹反轉, 然後回傳反轉後, 把root傳回parent
        TreeNode revLeft = invertTree(root.left);
        TreeNode revRight = invertTree(root.right);
        
        TreeNode temp = revLeft;
        root.left = revRight;
        root.right = temp;
        
        return root;
    }
}