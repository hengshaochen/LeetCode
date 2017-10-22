/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) { return null; }
        
        // 若p比root大或相等, p的後繼者一定在root的右子樹
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        // 若p比root小, 後繼者可能是當前的root, 或是更左邊
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            // 嘗試往左邊找successor
            if (left != null) {
                return left;
            }
            // 更左邊的為null, 代表更左邊沒有更小的successor, 自己(當前的root)一定是successor
            return root;
        }
    }
}