class Main {
    public static class ListNode<T> {
        ListNode<T> next;
        T val;
        public ListNode(T val) {
            this.val = val;
        }
    }
    
    public static class Queue<T> {
        ListNode<T> head;
        ListNode<T> tail;
        ListNode<T> q;
        T val;
        
        //LinkedList<T> q = new LinkedList<>();
        
        public Queue() {
            q = new ListNode(val);
            this.head = q;
            this.tail = q;
        }
        
        public Queue<T> add(T element) {
            tail.next = new ListNode(element);
            tail = tail.next;
            return this;
        }
        public T remove() {
            if (head.next == null) {
                new java.util.NoSuchElementException();
            }
            ListNode<T> remove_element = head.next;
            head.next = head.next.next;
            return remove_element.val;
        }
        public T peek() {
            if (head.next == null) {
                new java.util.NoSuchElementException();
            }
            return head.next.val;
        }
    }
    
    public static void main(String[] args) {
        Queue<String> my_queue = new Queue<>();
        my_queue.add("Rutgers University");
        my_queue.add("University of Texas");
        my_queue.add("Santa Clara University");
        
        System.out.println(my_queue.remove());
        System.out.println(my_queue.remove());
        
        my_queue.add("San Jose State University");
        my_queue.add("National Chiao Tung University");
        
        System.out.println(my_queue.remove());
        System.out.println(my_queue.remove());
        
        System.out.println(my_queue.peek());
    }
}

// 內建Linked-List版本
class Main {
    public static class Queue<T> {
        LinkedList<T> q = new LinkedList<>();
        
        public Queue() {
        }
        
        public Queue<T> add(T element) {
            q.add(element);
            return this;
        }
        public T remove() {
            return q.poll();
        }
        public T peek() {
            return q.peek();
        }
    }
    
    public static void main(String[] args) {
        Queue<String> my_queue = new Queue<>();
        my_queue.add("Rutgers University");
        my_queue.add("University of Texas");
        my_queue.add("Santa Clara University");
        
        System.out.println(my_queue.remove());
        System.out.println(my_queue.remove());
        
        my_queue.add("San Jose State University");
        my_queue.add("National Chiao Tung University");
        
        System.out.println(my_queue.remove());
        System.out.println(my_queue.remove());
        
        System.out.println(my_queue.peek());
    }
}