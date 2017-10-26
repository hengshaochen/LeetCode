/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            
            sum += (l1 != null) ? l1.val : 0;
            sum += (l2 != null) ? l2.val : 0;
            
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            
            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2; 
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        
        return dummy.next;
    }
}