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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //head = dummy;
        
        // if count == m --> cur need to rev
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode left_1 = null, left_2 = null;
        int count = 0;
        while (pre != null) {
            if (count == m - 1) {
                left_1 = pre;
                left_2 = cur;
            } else if (count >= m && count <= n - 1) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                count++;
                continue;
                
            } else if (count == n) {
                left_1.next = pre;
                left_2.next = cur;
            }
            if (pre != null) { pre = pre.next; }
            if (cur != null) { cur = cur.next; }
            count++;
        }
        
        return dummy.next;
    }
}