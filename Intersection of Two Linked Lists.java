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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个链表的长度不定，但是交叉节点的后续节点全部相同，所以先求得每个链表的长度lenA和lenB
        // 将较长的链表先移动|lenA−lenB|个位置，然后同时后移，遇到的第一个值相等的节点既是要求的交叉节点。
        
        ListNode copyA = headA;
        ListNode copyB = headB;
        int lengthA = 0, lengthB = 0;
        while (copyA != null) {
            copyA = copyA.next;
            lengthA++;
        }
        while (copyB != null) {
            copyB = copyB.next;
            lengthB++;
        }
        copyA = headA;
        copyB = headB;
        
        int diffLength = Math.abs(lengthA - lengthB);
        
        while (diffLength > 0) {
            if (lengthA > lengthB) {
                copyA = copyA.next;
            } else {
                copyB = copyB.next;
            }
            diffLength--;
        }
        
        while (copyA != null && copyB != null) {
            if (copyA == copyB) {
                return copyA;
            }
            copyA = copyA.next;
            copyB = copyB.next;
        }
        return null;
        
    }
}