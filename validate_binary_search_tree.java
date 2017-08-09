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
     * @return: True if the binary tree is BST, or false
     */
    ArrayList<Integer> inorder = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        
        helper(root);
        for (int i=0 ; i < inorder.size() -1 ; i++ ) {
            if (inorder.get(i) >= inorder.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    public void helper(TreeNode root) {
        if (root == null) { return; }
        helper(root.left);
        inorder.add(root.val);
        helper(root.right);
        return;
    }
}