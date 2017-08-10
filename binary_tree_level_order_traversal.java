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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null) { return ans; }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        // while (q != null) 會有bug 改成isEmpty() ok!
        while (!q.isEmpty()) {
            int LevelSize = q.size();
            ArrayList<Integer> local = new ArrayList<Integer>();
            for (int i=0 ; i < LevelSize ; i++) {
                TreeNode currentNode = q.remove();
                if (currentNode.left != null) { q.add(currentNode.left); }
                if (currentNode.right != null) { q.add(currentNode.right); }
                local.add(currentNode.val);
            }
            ans.add(local);
        }
        return ans;
    }
}