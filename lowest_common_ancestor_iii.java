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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) { return null; }
        ArrayList<TreeNode> pathA = new ArrayList<TreeNode>();
        ArrayList<TreeNode> pathB = new ArrayList<TreeNode>();
        pathA = findPath(root, A, new ArrayList<TreeNode>());
        pathB = findPath(root, B, new ArrayList<TreeNode>());

        return comparePath(pathA, pathB);
    }
    
    public ArrayList<TreeNode> findPath(TreeNode root, TreeNode targetNode, ArrayList<TreeNode> path) {
        if (root == null) { return null; }
        if (root.val == targetNode.val) {
            path.add(root);
            return path;
        }
        if (root.left == null && root.right == null) {
            return null; 
        }
        path.add(root);
        // 往左子,右子搜尋
        ArrayList<TreeNode> left = findPath(root.left, targetNode, new ArrayList<TreeNode>(path));
        ArrayList<TreeNode> right = findPath(root.right, targetNode, new ArrayList<TreeNode>(path));
        
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
    
    public TreeNode comparePath(ArrayList<TreeNode> pathA, ArrayList<TreeNode> pathB) {
        int i = 0;
        TreeNode answerNode = null;
        try {
            while (pathA.get(i).val == pathB.get(i).val) {
                answerNode = pathA.get(i);
                i += 1;
            }
        } catch (Exception ex) {
            // pathA.get(i) 越界 ArrayOutOfBound.
        }
        return answerNode;
    }
}