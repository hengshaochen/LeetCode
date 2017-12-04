
import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
        new Solution();
    }
    
    public Solution() {
		int[] preorder = {5,3,1,4,8,11};
		int[] inorder = {1,3,4,5,8,11};
        
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        in_traverse(root);
        
    }
    
    void in_traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        in_traverse(root.left);
        System.out.println(root.val);
        in_traverse(root.right);
        
    }

    TreeNode buildTree(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        // base case
        if (in_start > in_end) {
            return null;
        }

        int rootIdx = map.get(preorder[pre_start]);
        TreeNode root = new TreeNode(preorder[pre_start]);
        // 

        //
        int new_pre_end = pre_start + 1 + (rootIdx - in_start - 1);
         root.left = buildTree(preorder, pre_start + 1, pre_start + rootIdx - in_start,
                         inorder, in_start, rootIdx - 1);
        root.right = buildTree(preorder, pre_start + rootIdx - in_start + 1, pre_end,
                         inorder, rootIdx + 1, in_end);

            return root;
    }
}
