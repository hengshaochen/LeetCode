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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    // Divide and Conquer Version, by 9 chapter
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        // 1.結束條件
        if (root == null) { return result; }
        
        // 2.Divide
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        // 3.Conquer(Merge)
        /* 下for等價於這個for 
        for (int i = 0; i < left.size(); i ++) {
            result.add(root.val + "->" + left.get( i ));
        }
        */
        for (String path : left) {
            result.add(root.val + "->" + path);
        }
        for (String path : right) {
            result.add(root.val + "->" + path);
        }
        
        // root is a leaf
        if (result.size() == 0) {
            result.add("" + root.val);
        }
        
        return result;
    }
}
/*
    // Top Down Version
public class Solution {
    List<String> result = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder local = new StringBuilder();
        helper(root, local);
        return result;
    }
    public void helper(TreeNode root, StringBuilder local) {
        if (root == null) { return; }
        // 如果到尾端 --> 將local加入result
        if (root.left == null && root.right == null) {
            local.append(root.val);
            result.add(local.toString());
            return;
        }
        local.append(root.val + "->");
        // 往左子,右子搜尋
        helper(root.left, new StringBuilder(local));
        helper(root.right, new StringBuilder(local));
        return;
    }
}
*/