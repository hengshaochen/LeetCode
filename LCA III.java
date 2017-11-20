/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Result {
    TreeNode return_node;
    boolean p_exist;
    boolean q_exist;
    Result (boolean p, boolean q, TreeNode node) {
        return_node = node;
        p_exist = p;
        q_exist = q;
    }
}
class Solution {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // Root job? 如果p或q其中一個等於root, 回傳root本身 / 如果左右子樹都有東西, LCA就是root本身 / 
        // 注意：在root的情況下, 要p跟q都有遇到才能return, 不然就return null
        // 奇怪？root的定義跟其他子節點定義不太一樣怎麼辦？使用helper function, 把helper function回傳回來的在自己判斷一下即可
        Result rootResult = helper(root, p, q);
        if (rootResult.p_exist == true && rootResult.q_exist == true) {
            return rootResult.return_node;
        }
        return null;
    }
    
    Result helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(false, false, root);
        }
        
        Result left = helper(root.left, p, q);
        Result right = helper(root.right, p, q);
        
        boolean p_exist = left.p_exist || right.p_exist || root == p;
        boolean q_exist = left.q_exist || right.q_exist || root == q;
        
        if (root == p || root == q) {
            return new Result(p_exist, q_exist, root);
        }
        
        if (left.return_node != null && right.return_node != null) {
            return new Result(p_exist, q_exist, root);
        }
        
        if (left.return_node != null) {
            return new Result(p_exist, q_exist, left.return_node);
        }
        if (right.return_node != null) {
            return new Result(p_exist, q_exist, right.return_node);
        }
        return new Result(p_exist, q_exist, null);
        
    }
}