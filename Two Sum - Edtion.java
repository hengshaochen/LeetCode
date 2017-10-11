// 不使用額外空間 --> 還沒想出來
// 一個指向最右下角(max), 然後依照2ptr的2 sum作法, 若兩個相加比target大, 移動右邊指標 往右邊指標的父親節點移動, 但這個操作我想了一陣子時做不出來, 以下我目前的寫法...另外這題好像沒有標準答案.
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
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        // 2 ptr, one point to current minimum, one point to current maximum
        // maximum : 右印左
        // minimum : 左印右
        // 如果 root(min) + root(max) > target 移動maximum
        TreeNode min = root;
        TreeNode max = root;
        helper(max, min, n);
        
    }
    public void helper(TreeNode max, TreeNode min, int target) {
        if (max == null || min == null) { return; }
        helper(max.right, root, target);
        helper(root, min.left, target);
        
        if (min.val + max.val > target) {
            // max往父親移動
            
        } else if (min.val + max.val < target) {
            // min往父親移動
        } else {
            // 找到答案
        }
        
    }
}

// 使用中序變sorted array （額外空間n) + two sum (2ptr) O(n) 一個指向最右下角(max), 然後依照2ptr的2 sum作法, 若兩個相加比target大, 移動右邊指標 往右邊指標的父親節點移動, 但這個操作我想了一陣子時做不出來, 以下我目前的寫法...另外這題好像沒有標準答案.
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
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        // 用額外樹的node數量的空間
        List<Integer> tree = new ArrayList<>();
        int[] ans = new int[2];
        
        // BST中序 --> sorted order
        inorder(root, tree);
        
        // 對arraylist用2ptr做two sum
        int i = 0, j = tree.size() - 1;
        while (i < j) {
            if (tree.get(i) + tree.get(j) == n) {
                ans[0] = tree.get(i);
                ans[1] = tree.get(j);
                i++;
                j--;
                return ans;
            } else if (tree.get(i) + tree.get(j) > n){
                j--;
            } else {
                i++;
            }
        }
        
        return null;
    }
    void inorder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, tree);
        tree.add(root.val);
        inorder(root.right, tree);
    }
}