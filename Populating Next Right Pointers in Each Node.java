/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // root.right != null --> root.left.next = root.right
        // root.next != null --> root.right.next = root.next.left
        if (root == null) {
            return;
        }
        // leaf node 就不應該再判斷他的root.right.next,會出錯, 因此在這邊先回傳
        if (root.left == null && root.right == null) {
            return;
        }
        
        if (root.right != null) {
            root.left.next = root.right;
        }
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
    }
}