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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
     // root --> String
    public String serialize(TreeNode root) {
        if (root == null) { return "{}"; }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        sb.append("{");
        while (!q.isEmpty()) {
            TreeNode currentNode = q.remove();
            if (currentNode != null) {
                sb.append(currentNode.val + ",");
                q.add(currentNode.left);
                q.add(currentNode.right);
            } else {
                sb.append("#,");
            }
        }
        // 去除多餘,# ex: 3,9,20,#,#,15,7,#,#,#,#,
        int deleteIndex;
        for (deleteIndex = sb.length() - 1 ; deleteIndex >= 0 ; deleteIndex--) {
            if (Character.isDigit(sb.charAt(deleteIndex)) == true ) {
                break;
            }
        }
        // *beginning index, inclusive. ending index, exclusive.
        sb.delete(deleteIndex + 1, sb.length() );
        sb.append("}");
        
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
     // string --> array --> TreeNode
    public TreeNode deserialize(String data) {
                if (data.equals("{}")) { return null; }
        // 去頭尾括號
        String[] arr = data.substring(1,data.length()-1).split(",");
        //System.out.println(arr[0]);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode currentNode = q.remove();
            if (currentNode == null) { continue; }
            //System.out.println("i:" + i + "cur:" + currentNode.val);
            // 左子樹 if: 數字 else: #
            // if (!Arrays.equals(arr[i], "#")) 為何不能比較？
            if (i < arr.length && !arr[i].equals("#")) {
                currentNode.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(currentNode.left);
            } else {
                currentNode.left = null;
                //q.add(null);
            }
            i += 1;
            
            // 右子樹 if: 數字 else: #
            if (i < arr.length && !arr[i].equals("#")) {
                currentNode.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(currentNode.right);
            } else {
                currentNode.right = null;
                //q.add(null);
            }
            i += 1;
        }
        
        return root;
    }
}
