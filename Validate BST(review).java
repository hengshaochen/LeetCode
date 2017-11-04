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
    public boolean isValidBST(TreeNode root) {
        // 思路2: BST走中序輸出會是小到大排序好, 因此設一個pre跟cur, 如果是bst的話, cur的值一定會比pre大
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        while (!s.empty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (pre != null && cur.val <= pre.val) {
                return false;
            }
            // 存前一個node
            pre = cur;
            cur = cur.right;
        }
        
        return true;
        
    }
}


// recursive
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
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        // 向右更新min, 向左更新max
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        
        dfs(root, min, max);
        
        return ans;
    }
    
    void dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return;
        }
        if (root.val <= min || root.val >= max) {
            ans = false;
            return;
        }
        
        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
        
    }
    
    
}