// Correct
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
        if (root == null) {
            return;
        }
        
        // 找下一個應該要接的點
        TreeLinkNode nextNode = root.next;
        while (nextNode != null) {
            if (nextNode.left != null) {
                nextNode = nextNode.left;
                break;
            } else if (nextNode.right != null) {
                nextNode = nextNode.right;
                break;
            }
            nextNode = nextNode.next;
        }
        
        // 接上去, 右邊優先, 在接左邊
        if (root.right != null) {
            root.right.next = nextNode;
            if (root.left != null) {
                root.left.next = root.right;
            }
        } else if (root.left != null) {
                root.left.next = nextNode;
        }
        // 先走右邊在走左邊
        connect(root.right);
        connect(root.left);
        
    }
}


// Bug
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
        
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        
        TreeLinkNode cur_root = root;
        while (root.next != null) {
            System.out.println(root.val);
            if (root.next != null && root.right != null) {
                if (root.next.left != null) {
                    root.right.next = root.next.left;
                    break;
                } else if (root.next.right != null) {
                    root.right.next = root.next.right;
                    break;
                }
            } else if (root.next != null && root.left != null) {
                if (root.next.left != null) {
                    root.left.next = root.next.left;
                    break;
                } else if (root.next.right != null) {
                    root.left.next = root.next.right;
                    break;
                }
            }
            root = root.next;
        }
        
        root = cur_root;
        /*
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            if (root.next.left != null) {
                root.right.next = root.next.left;
            } else if (root.next.right != null) {
                root.right.next = root.next.right;
            }
        }
        */
        
        connect(root.left);
        connect(root.right);
    }
}