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
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) { return null; }
        
        Queue<ListNode> min_heap = new PriorityQueue<>(lists.size(), ListNodeComparator);
        
        // 把k個List中所有node放到priority queue(min heap)中
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                ListNode curList = lists.get(i);
                while (curList != null) {
                    min_heap.add(curList);
                    curList = curList.next;
                }
            }
        }
        
        // 把priority queue全部poll出來
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!min_heap.isEmpty()) {
            cur.next = min_heap.poll();
            cur = cur.next;
        }
        
        
        return dummy.next;
    }
}
