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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists.size() == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        return mergeSort(lists, 0, lists.size() - 1);
    }
    public ListNode mergeSort(List<ListNode> lists, int start, int end) {
        // 如果不能再切割, 回傳頭
        if (start >= end) { 
            return lists.get(start);
        }
        
        int mid = (start + end) / 2;
        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        
        return dummy.next;
    }
}
