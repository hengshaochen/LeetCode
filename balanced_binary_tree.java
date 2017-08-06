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
        //int depth = 0;
        helper(root, 0);
        return isBal;
    }
    public int helper(TreeNode root, int depth) {
        if (root == null) { return 0; }
        if (root.left == null && root.right == null) { return depth + 1; }
    
        int left = helper(root.left, depth);
        int right = helper(root.right, depth);
        
        if (Math.abs(left - right) > 1) {
            isBal = false;
        }
        // 先前卡的地方, 想清楚當前node的高度怎麼算, 再來回傳
        // return depth + 1;  // 當前node高度必須取(左子)(右子)的最大值
        return Math.max(left,right) + 1;  // **務必注意, 下次別再錯了
    }
}