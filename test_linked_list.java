class Main {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode head = node1;
        System.out.println(head);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
        
        ListNode buf = head;
        while (buf != null) {
            System.out.print(buf.val + " "); // 會印出1,2,3
            buf = buf.next;
        }

        System.out.println("------------");
        node1 = node2;
        System.out.println(head);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
        
        buf = head;
        while (buf != null) {
            System.out.print(buf.val + " "); // 還是會印出1,2,3
            buf = buf.next;
        }
    }
}