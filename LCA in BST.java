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
        // BST root比左子樹大, root比右子樹小
        // 如果p和q都比root小, LCA在左子樹
        // 如果p和q都比root大, LCA在右子樹
        // 如果p < root && q > root --> LCA是root || p > root && q < root --> LCA是root || root = p || root == q --> LCA是root
        
        // 特判
        if (root == null || p == null || q== null) {
             return null;
        }
        
        // General Case
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}