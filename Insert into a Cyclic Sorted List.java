/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        if (node == null) { 
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        ListNode head = node;
        while (node != null) {
            //  在linked-list內部
            if (node.val < node.next.val) {
                if (x >= node.val && x <= node.next.val) {
                    insertNode(node, x);
                    break;
                }
            }
            // 在linked-list尾端
            else if (node.val > node.next.val) {
                // x >= 最後一個node 或 x < 第一個node ex:3->1, 插入0
                if (x >= node.val || x <= node.next.val) {
                    insertNode(node, x);
                    break;
                }
            }
            // node.val == node.next.val || 當只有一個node的時候(ex: 1)
            else {
                if (node.next == head) {
                    insertNode(node, x);
                    break;
                }
            }
            node = node.next;
        }
        return node;
    }
    private void insertNode(ListNode node, int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = node.next;
        node.next = newNode;
    }
}