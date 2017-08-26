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
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        if (head == null) { return false; }
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast != slow) {
            // 若任一指標都指向null --> 沒cycle
            // 要加fast.next是因為避免outOfBoundary,
            // 若fast.next為null, fast.next.next會outOfBoundary
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 若fast == true, 代表快慢指標相遇 --> 有cycle
        return true;
    }
}
