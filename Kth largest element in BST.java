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
    public int kthLargestest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        int total = countNodes(root);
        //System.out.println(total);
        int count = 0;
        
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            count++;
            if (count == total - k + 1) {
                return cur.val;
            }
            
            cur = cur.right;
        }
        
        return -1;
    }
    
    int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}