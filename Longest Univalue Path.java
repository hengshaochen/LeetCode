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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        // 每次更新max可以左右子樹同時使用
        // 但是每次return只能回傳左子樹跟右子樹最長的
        if (root == null) {
            return 0;
        }
        helper(root);
        
        return max;
    }
    
    // 需要寫helper, 定義helper回傳該樹的最長unipath（只能用左右中最長的）
    // 而main function是要回傳（可以用左＋root＋右）的答案
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int left_plus_root = 0;
        int right_plus_root = 0;
        
        if (root.left != null && root.left.val == root.val) {
            left_plus_root = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right_plus_root = right + 1;
        }
        max = Math.max(max, left_plus_root + right_plus_root);
        
        return Math.max(left_plus_root, right_plus_root);
    }
}