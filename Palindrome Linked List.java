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


// Time: O(n) Space:O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 1 -> 2 -> 3 -> N
                 s         f
                
           1  -> 2 -> 3 -> 4 
                 mid  
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode mid = findMid(head);
        mid.next = revList(mid.next);
        ListNode p1 = head;
        ListNode p2 = mid.next;
        
        // odd: 1 -> 2  vs 1 -> 2 ok 
        // even: 1 -> 2 -> 3 -> 4     p1: 1   ,  p2: 3 -> 4 (p2一定比p1長)
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        if (p2 != null) {
            return false;
        }
        return true;
        
    }
    
    ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    ListNode revList(ListNode head) {
        // 1 -> 2 -> N  --->  2 -> 1 -> N
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}