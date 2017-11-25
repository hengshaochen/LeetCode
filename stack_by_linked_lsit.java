public class Solution {
public class StackLinkedList<T> {
    Node top;
    class Node {
        private T ele;
        private Node next;
        public Node(T ele) {
            this.ele = ele;
        }
    }
    
    public StackLinkedList() {
        top = null;
    }
    public StackLinkedList<T> push(T ele) {
        Node newElement = new Node(ele);
        newElement.next = top;
        top = newElement;
        
        return this;
    }
    public T pop() {
        if (top == null) {
            new java.util.NoSuchElementException();
        }
        Node popElement = new Node(top.ele);
        top = top.next;
        return popElement.ele;
    }
    public T peek() {
        return top.ele;
    }
    

}
    public void partition2(int[] nums, int low, int high) {
        StackLinkedList<Integer> s = new StackLinkedList<>();
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(10);
        s.push(20);
        s.push(2);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}