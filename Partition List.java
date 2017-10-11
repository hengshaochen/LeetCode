/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) { return null; }
        ListNode p = new ListNode(0);
        ListNode p_head = p;
        ListNode dummy = head;
        
        // 找比x小的
        while (head != null) {
            if (head.val < x) {
                p.next = new ListNode(head.val);
                p = p.next;
            }
            head = head.next;
        }
        
        head = dummy;
        // 找>=x的
        while (head != null) {
            if (head.val >= x) {
                p.next = new ListNode(head.val);
                p = p.next;
            }
            head = head.next;
        }
        
        return p_head.next;
        
    }
}

// 標準答案
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */

public class Solution {
// 用兩個dummy, 兩個移動指標, 總共四個指標. 比x小連接left, >=x連接right
// 最後right.next 要變成null(因為會殘留head的後續linked-list), left.next街上right的起頭 也就是rightDummy
    public ListNode partition(ListNode head, int x) {
        if (head == null) { return null; }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);    
        
        ListNode left = leftDummy, right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}