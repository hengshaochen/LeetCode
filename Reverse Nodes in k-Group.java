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
        
        head = dummy;
        
        while (true) {
            head = revK(head, k);
            if (head == null) {
                break;
            }
        }
        // 把prev的後面k個點進行reverse, 並回傳倍reverse的那串的頭, 讓prev可以順利接到
        return dummy.next;
    }
    
    public ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        
        if (nk == null) {
            return null;
        }
        
        // reverse        
        ListNode n1 = head.next;
        ListNode nkplus = nk.next; 
        
        ListNode prev = null;
        ListNode curt = n1;
        while (curt != nkplus) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        // connect
        head.next = nk;
        n1.next = nkplus;
        return n1;
    }

    private ListNode revK(ListNode head, int k) {
        System.out.println(head.val);
        ListNode nk = head;
        // 測試是否越界, 並同時抓取end
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        
        // 这里的nk代表的正好是第k个数，nk为null说明后面不足k个数，需要返回null
        // ?
        if (nk == null) {
            return null;
        }
        
        
        // head -> n1 -> n2 -> end
        // head -> n2 -> n1 -> end
        ListNode n1 = head.next;
        ListNode end = nk.next;
        
        ListNode prev = null;
        ListNode curt = n1;
        while (curt != end) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        // connect
        head.next = nk;
        n1.next = end;
        return n1;
    }
};