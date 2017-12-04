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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
            0 1 2 3 4 5 6
        後: 1 4 3 6 8 7 5    left tree: 1, 4, 3  (0 ~ 2)  right tree: 6,8,7 (3 ~ 5)
        中: 1 3 4 5 6 7 8    left tree: 1, 3, 4  (0 ~ 2)  right tree: 6,7,8 (4 ~ 6)
            
            rootIdx = 3
        */
        // value, inorder-idx
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    TreeNode build(int[] inorder, int in_start, int in_end, int[] postorder, int pos_start, int pos_end) {
        // 1. base case
        if (in_start > in_end) {
            return null;
        }
        
        int rootIdx = map.get(postorder[pos_end]);
        TreeNode root = new TreeNode(postorder[pos_end]);
        
        root.left = build(inorder, in_start, rootIdx - 1, postorder, pos_start, pos_start + (rootIdx - in_start) - 1);
        root.right = build(inorder, rootIdx + 1, in_end, postorder, pos_start + (rootIdx - in_start), pos_end - 1);
        return root;
    }
}