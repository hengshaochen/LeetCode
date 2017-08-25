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
    public ListNode reverseLinkedList(ListNode head) {
    	// input: 1 -> 2 -> 3
    	// output: 3 -> 2 -> 1
    	ListNode pre = null;

    	while (head != null) {
	    	// Step1: 紀錄當前的下一個
	    	ListNode temp = head.next;
	    	// Step2: 當前的下一個變成NULL
	    	head.next = pre;
	    	// Step3: 2個指標往後移動
	    	pre = head;
	    	head = temp;
    	}
    	

    }
};