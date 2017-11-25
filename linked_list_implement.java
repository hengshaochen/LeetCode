class Main {
    public static class ListNode<T> {
        ListNode next;
        T val;
        public ListNode(T val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        // 題目： 寫一個linked-list然後建立1->2->3->4->5接著刪除3
        ListNode<Integer> dummy = new ListNode(0);
        ListNode<Integer> mylist = new ListNode(1);
        dummy.next = mylist;
        
        mylist.next = new ListNode(2);
        mylist = mylist.next;
        
        // 為了後續刪除3
        ListNode pre = mylist;
        
        mylist.next = new ListNode(3);
        mylist = mylist.next;
        
        mylist.next = new ListNode(4);
        mylist = mylist.next;
        ListNode four = mylist;
        
        mylist.next = new ListNode(5);
        mylist = mylist.next;
        
        // delete刪除 3
        pre.next = four;
        
        
        while (dummy.next != null) { 
            System.out.println(dummy.next.val);
            dummy = dummy.next;
        }        
    }
}