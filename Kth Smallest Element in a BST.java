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
// O(logn * countNode)
  public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            // 嚴格往左
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            // 嚴格往右
            // 新的k是原本舊的k - root - 左子樹數量
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}

///

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
    int ans = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        // inorder traversal, and pick with kth element
        inorder(root, k);
        return ans;
    }
    void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, k);
        count++;
        
        if (k == count) {
            ans = root.val;
        }
        
        inorder(root.right, k);        
    }
}