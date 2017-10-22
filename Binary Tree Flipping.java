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
     TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        DFS(root);
        return newRoot;
    }
    
    public void DFS(TreeNode cur) {
        // 新的root在最左下角
        if (cur.left == null) {
            newRoot = cur;
            return;
        }
        
        // 先遞回到最下面總監再開始做事
        DFS(cur.left);
        
        TreeNode l = cur.left;
        TreeNode r = cur.right;
        
        l.left = r;
        l.right = cur;
        
        // 注意：要把cur往左右子樹的連接線刪除
        cur.left = null;
        cur.right = null;
        
        // DFS(cur.right); 不需要這行, 因為input的bt是只有左子或右子只有一個node,
        // 直接走訪root就能走到右兒子
    }
}