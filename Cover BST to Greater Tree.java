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
    /**
     * @param root the root of binary tree
     * @return the new root
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // 對BST走右印左
        // 用一個sum記錄當前累積的sum
        helper(root);
        
        return root;
    }
    
    public void helper(TreeNode cur) {
        if (cur == null) { return; }
        helper(cur.right);
        sum = sum + cur.val;
        cur.val = sum;
        helper(cur.left);
    }
}