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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
     boolean isBal = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) { return isBal; }
        getHeight(root);
        return isBal;
    }
    public int getHeight(TreeNode cur) {
        // leaf 再往下走 null
        if (cur == null) { return 0; }
        
        int left = getHeight(cur.left);
        int right = getHeight(cur.right);
        
        if (Math.abs(left - right) >= 2) {
            isBal = false;
        }
        return Math.max(left, right) + 1;
    }
}