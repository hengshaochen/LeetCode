/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 1 2 3 2 1
             1 2 3 2 1 --> 1 2 3 2 1 same as the input --> true
             1 3 3 2 1 --> 1 2 3 3 1
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        
        ListNode dummy = head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        
        head = dummy;
        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}