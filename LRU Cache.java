public class LRUCache {
    private class Node{
        Node pre;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.pre = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node current = map.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        move_current_to_tail(current);
        
        return map.get(key).value;
    }
    
    private void move_current_to_tail(Node current) {
        current.pre = tail.pre;  // cur.pre 指向 原本的last
        tail.pre = current; // tail的前一個變成current
        current.pre.next = current; // current.pre(就是原本last的下一個) 指向current
        current.next = tail;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // 如果這個key原本就存在, 則調整位置return, 不需要set
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            // 刪除head.next
            map.remove((head.next).key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        
        Node insert = new Node(key, value);
        map.put(key, insert);
        move_current_to_tail(insert);
    }
}