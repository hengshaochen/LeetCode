/**
 * Definition for ListNode
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
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length <= 0) { return hashTable; }
        int capacity = hashTable.length;
        int newCapacity = 2 * capacity;
        ListNode[] newHashTable = new ListNode[newCapacity];
        
        for (int i = 0; i < hashTable.length; i++) {
            ListNode oldPtr = hashTable[i];
            while (oldPtr != null) {
                int newIndex = ((oldPtr.val % newCapacity) + newCapacity) % newCapacity;
                
                // 該坑沒人佔(沒碰撞 collision)
                if (newHashTable[newIndex] == null) {
                    newHashTable[newIndex] = new ListNode(oldPtr.val);
                } 
                // 代表有該坑有人佔, 往那個坑的下方排隊
                else
                {
                    ListNode dummy = newHashTable[newIndex];
                    // 確保dummy.next為null, 下一行就可以把dummy.next新增東西
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(oldPtr.val);
                }
                /*
                // 錯誤寫法：要使用dummy node
                System.out.println(oldPtr.val);
                ListNode ptr = newHashTable[newIndex];
                while (ptr != null) {
                    ptr = ptr.next;
                }
                ptr = new ListNode(oldPtr.val);*/
                oldPtr = oldPtr.next;
            }
        }
        
        return newHashTable;
    }
};
// Review 11/10
/**
 * Definition for ListNode
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
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int newCap = hashTable.length * 2;
        ListNode[] newHashTable = new ListNode[newCap];
        
        for (int i = 0; i < hashTable.length; i++) {
            ListNode cur = hashTable[i];
            while (cur != null) {
                int new_index = ((cur.val % newCap) + newCap) % newCap;
                
                if (newHashTable[new_index] == null) {
                    newHashTable[new_index] = new ListNode(cur.val);
                } else {
                    ListNode dummy = newHashTable[new_index];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(cur.val);
                }
                cur = cur.next;
            }
        }
        return newHashTable;
    }
};

