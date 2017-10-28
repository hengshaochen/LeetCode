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
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // remove the last #n element in linked-list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // get length
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        
        // length - n = index of the element that needs to remove
        head = dummy;
        int remove_index = len - n;
        int count = 0;
        while (head.next != null) {
            if (count == remove_index) {
                head.next = head.next.next;
                break;
            } else {
                head = head.next;
                count++;
            }
        }
        return dummy.next;
    }
}

// Good ans
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
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // remove the last #n element in linked-list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        
        while (p2 != null) {
            if (p2.next == null) {
                p1.next = p1.next.next;
            }
            p1 = p1.next;
            p2 = p2.next;
            
        }
        
        return dummy.next;
    }
}