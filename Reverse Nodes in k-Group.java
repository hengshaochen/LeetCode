/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        while (pre != null) {
            System.out.println(pre.val);
            pre = reverseGroup(pre, k);
        }
        return dummy.next;
    }
    ListNode reverseGroup(ListNode pre, int k) {
        
        ListNode k1 = pre.next;
        ListNode kn = pre;
        for (int i = 0; i < k; i++) {
            // 防止越界 null不能再指向null
            // example: 3->null , k = 2
            if (kn == null) {
                return null;
            }
            kn = kn.next;
        }
        // 防止越界, ex: 3->2->null, k = 2
        if (kn == null) {
            return null;
        }
        
        ListNode post = kn.next;
        
        ListNode cur = k1;
        ListNode previous = null;
        while (cur != post) {
            ListNode temp = cur.next;
            cur.next = previous;
            previous = cur;
            cur = temp;
        }
        
        pre.next = kn;
        k1.next = post;
        return k1;
    }
}