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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public TreeNode flat = new TreeNode(0);
    public void flatten(TreeNode root) {
        if (root == null) { return; }
        TreeNode flatHead = flat;
        helper(root);
        root.left = null;
        root.right = (flatHead.right).right;
    }
    public void helper(TreeNode root) {
        if(root == null) { return; }
        //flat = new TreeNode(root.val); *** 造成錯誤的地方, 要用接上去的！
        flat.right = new TreeNode(root.val);
        flat = flat.right;
        helper(root.left);
        helper(root.right);
    }
}