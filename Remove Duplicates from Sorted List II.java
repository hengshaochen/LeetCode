// correct
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
    /*
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}

// need fix
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
    /*
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 只保留沒有重複的元素
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (head.next != null) {
            if (head.val == head.next.val) {
                // make sure head.next is not duplicate element
                while (head.next != null && head.next.next != null && 
                       head.val == head.next.val || head.next.val == head.next.next.val) {
                    head = head.next;
                }
                pre.next = head.next;
                pre = pre.next;
                if (pre.next != null) {
                    head = pre.next;
                    head.next = pre.next.next;
                }
                
            } else {
                pre = pre.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}