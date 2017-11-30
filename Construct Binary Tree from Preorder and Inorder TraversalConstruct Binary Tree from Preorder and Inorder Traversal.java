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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null ||  inorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    
    TreeNode buildTree(int[] inorder, int in_start, int in_end, int[] preorder, int pre_start, int pre_end) {
        if (in_start > in_end) {
            return null;
        }
        
        int root_idx = map.get(preorder[pre_start]);
        TreeNode root = new TreeNode(preorder[pre_start]);
        
        // System.out.println("inorder:" + in_start +" " + in_end +" preOrder"+pre_start +" " + pre_end);
        
        root.left = buildTree(inorder, in_start, root_idx - 1,
                              preorder, pre_start + 1, pre_start + 1 + (root_idx - 1 - in_start));
        root.right = buildTree(inorder, root_idx + 1, in_end,
                               preorder, pre_start + 1 + (root_idx - 1 - in_start) + 1, pre_end);
        
        return root;
    }
}