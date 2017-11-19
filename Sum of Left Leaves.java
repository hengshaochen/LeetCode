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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    
    int helper(TreeNode root, boolean l) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (l == true) {
                return root.val;
            } else {
                return 0;
            }
        }
        
        int left = helper(root.left, true);
        int right = helper(root.right, false);
        
        return left + right;
    }
}