/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        copyNode(head);
        copyRandom(head);
        //return head;
        return splitList(head);
    }
    private void copyNode(RandomListNode head) {
        // 1->2->3  =>  1->1'->2->2'->3->3'
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    private void copyRandom(RandomListNode head) {
        // 前面複製出的1'->2'...都有random, 但目前是指向原本1->2的random, 要改成指向1'->2'的ranodm
        while (head != null) {
            if (head.random != null) {
                // ex: 1->1'->2->2' , 1的random指向2, 則1'的random要指向2'
                // head.next.random = 1' , head.random為2, head.random.next為2'
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    // ??
    private RandomListNode splitList(RandomListNode head) {
        // 把串列拆成1'->2'->3'
        // temp指向當前欲處理的”複製節點“
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }
}