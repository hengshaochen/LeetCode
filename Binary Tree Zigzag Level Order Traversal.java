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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) { return ans; }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        // while (q != null) 會有bug 改成isEmpty() ok!
        boolean isEven = false;
        while (!q.isEmpty()) {
            int LevelSize = q.size();
            ArrayList<Integer> local = new ArrayList<Integer>();
            for (int i=0 ; i < LevelSize ; i++) {
                TreeNode currentNode = q.remove();
                if (currentNode.left != null) { q.add(currentNode.left); }
                if (currentNode.right != null) { q.add(currentNode.right); }
                local.add(currentNode.val);
            }
            if (isEven == false) {
                ans.add(local);
                isEven = true;
            } else {
                Collections.reverse(local);
                ans.add(local);
                isEven = false;
            }
        }
        return ans;
    }
}