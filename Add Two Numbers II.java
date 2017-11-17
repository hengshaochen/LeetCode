/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // rev 2 list
        l1 = revList(l1);
        l2 = revList(l2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // add two list
        int carry = 0;
        while (l1 != null && l2 != null) {
            //System.out.println(carry);
            int cur_val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            
            cur.next = new ListNode(cur_val);
            cur = cur.next;
            
            l1  = l1.next;
            l2 = l2.next;
            
        }
        while (l1 != null) {
            int cur_val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            cur.next = new ListNode(cur_val);
            cur = cur.next;
            l1  = l1.next;
        }
        while (l2 != null) {
            int cur_val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            cur.next = new ListNode(cur_val);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        
        dummy.next = revList(dummy.next);
        return dummy.next;
    }
    
    ListNode revList(ListNode list) {
      /*
      n 1->2->3->null
      p c
      n<-1->2->3->null
         p c     
      n<-1<-2->3->null
            p c   
      n<-1->2<-3->null
               p c   
      */
        ListNode cur = list;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

// Stack (Without reverse)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        
        // traverse 2 lists
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        
        // add two list, and connect the list in rev order
        // 3+4 = 7 tail
        // 4+6 = 0 cur
        // cur -> tail  0 --> 7
        ListNode tail = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if (!s1.isEmpty()) {
                sum += s1.pop().val;
            }
            if (!s2.isEmpty()) {
                sum += s2.pop().val;
            }
            carry = sum / 10;
            sum = sum % 10;
            
            ListNode cur = new ListNode(sum);
            cur.next = tail;
            tail = cur;
        }
        if (carry != 0) {
            ListNode cur = new ListNode(carry);
            cur.next = tail;
            tail = cur;
        }
        return tail;
    }
}