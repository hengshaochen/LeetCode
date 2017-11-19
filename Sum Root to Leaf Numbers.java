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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return total;
    }
    void preorder(TreeNode root, int sum) {
        // 如果遇到null要直接return, 不能取NULL的left或是value
        if (root == null) {
            return;
        }
        sum = (10 * sum) + root.val;
        
        // 到leaf, 把當前path總合加到total裡面
        if (root.left == null && root.right == null) {
            total = total + sum;
            return;
        }
        
        preorder(root.left, sum);
        preorder(root.right, sum);
    }
}

// fail
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
    class Result {
        int digit;
        int sum;

        Result(int sum, int digit) {
            this.sum = sum;
            this.digit = digit;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        // root's job: sum of left subtree + 10 ^ left subtree_digit * root.val + 右邊以此類推
        // root's return: sum of value, current digit + 1
        return helper(root).sum;
    }
    
    Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        if (root.left == null && root.right == null) {
            return new Result(root.val, 1);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        
        int cur_sum = 0;
        if (left.digit != 0) {
            cur_sum += (left.sum + ( (int)Math.pow(10, left.digit) * root.val));
        }
        if (right.digit != 0) {
            cur_sum += (right.sum + ( (int)Math.pow(10, right.digit) * root.val));
        }
        System.out.println(cur_sum);
        return new Result(cur_sum, Math.max(left.digit, right.digit) + 1);
    }
}