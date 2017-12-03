// 正確版本
import java.util.*;

class Node {
    String companyName;
    int price;
    Node pre;
    Node next;
    
    Node (String companyName, int price) {
        this.companyName = companyName;
        this.price = price;
        this.pre = null;
        this.next = null;
    }
}

public class Solution {
    static HashMap<String, Integer> priceMap = new HashMap<>();
    static HashMap<String, Node> topMap = new HashMap<>();
    static int capacity;
    static Node head = new Node("", -1);
    static Node tail = new Node("", -1);
    
    public static void init(int k) {
        head.next = tail;
        tail.pre = head;
        capacity = k;
    }
    
    public static void main(String[] args) {
        init(3);
        addCompany("Google", 235);
        addCompany("Mxic", 60);
        //addCompany()
        //addCompany("BC", 5);
        topK();
        addCompany("Amazon", 1200);
        addCompany("Amazon", 4200);
        addCompany("APPLE", 9000);;
        addCompany("TSMC", 45);;
        addCompany("APPLE", 10222);
        topK();
        
    }
    
    public static void addCompany(String name, int price) {
        // 1. Put company in HashMap
        priceMap.put(name, price);
        
        // 2. Maintain the topMap / LinkedList
        // if current company already in topMap, adjust the position
        // else topMap.size() == capacity -->  if current node is greater than the end node --> insert --> adjust
        if (topMap.containsKey(name)) {
            Node remove = topMap.get(name);
            topMap.remove(name);
            
            remove.pre.next = remove.next;
            remove.next.pre = remove.pre;
        }
        
        if (topMap.size() == capacity) {
            if (price > tail.pre.price) {
                // delete the end and insert current
                topMap.remove(tail.pre.companyName);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
            } else {
                return;
            }
        }
        // insert
        Node newNode = new Node(name, price);
        topMap.put(name, newNode);
        
        
        // adjust the position
        adjust(newNode);
    }
    public static void adjust(Node current) {
        Node traverse = head.next;
        
        boolean tag = false;
        while (traverse != tail) {
            if (current.price > traverse.price) {
                //Node temp = traverse.next;
                current.pre = traverse.pre;
                traverse.pre.next = current;
                current.next = traverse;
                traverse.pre = current;
                tag = true;
                break;
            }
            traverse = traverse.next;
        }
        if (tag == false) {
            // ins到最尾端
            Node temp = tail.pre;
            tail.pre = current;
            current.next = tail;
            current.pre = temp;
            temp.next = current;
        }
    }
    public static void topK() {
        Node cur = head.next;
        while (cur != tail) {
            System.out.println(cur.companyName + ": " + cur.price);
            cur = cur.next;
        }
        System.out.println("");
    }
}

// Debug version:
import java.util.*;

class Node {
    String companyName;
    int price;
    Node pre;
    Node next;
    
    Node (String companyName, int price) {
        this.companyName = companyName;
        this.price = price;
        this.pre = null;
        this.next = null;
    }
    void modifyPrice(int newprice) {
        this.price = newprice;
    }
}

public class Solution {
    static HashMap<String, Integer> priceMap = new HashMap<>();
    static HashMap<String, Node> topMap = new HashMap<>();
    static int capacity;
    static Node head = new Node("", -1);
    static Node tail = new Node("", -1);
    
    public static void init(int k) {
        head.next = tail;
        tail.pre = head;
        capacity = k;
    }
    
    public static void main(String[] args) {
        init(3);
        addCompany("Google", 235);
        addCompany("Mxic", 60);
        //addCompany()
        System.out.println(tail.pre.companyName);
        System.out.println(head.next.companyName);
        //addCompany("BC", 5);
        topK();
        addCompany("Amazon", 1200);
        addCompany("APPLE", 9000);
        addCompany("TSMC", 45);
        topK();
        
    }
    
    public static void addCompany(String name, int price) {
        // 1. Put company in HashMap
        priceMap.put(name, price);
        
        // 2. Maintain the topMap / LinkedList
        // if current company already in topMap, adjust the position
        // else topMap.size() == capacity -->  if current node is greater than the end node --> insert --> adjust
        if (topMap.containsKey(name)) {
            //topMap.get(name).modifyPrice(price);
            adjust(topMap.get(name));
            return;    
        }
        
        if (topMap.size() == capacity) {
            if (price > tail.pre.price) {
                // delete the end and insert current
                topMap.remove(tail.pre.companyName);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
            } else {
                return;
            }
        }
        // insert
        Node newNode = new Node(name, price);
        topMap.put(name, newNode);
        
        
        // adjust the position
        adjust(newNode);
    }
    public static void adjust(Node current) {
        Node traverse = head.next;
        
        boolean tag = false;
        while (traverse != tail) {
            if (current.price > traverse.price) {
                System.out.println("insert to not tail: " + current.companyName);
                //Node temp = traverse.next;
                current.pre = traverse.pre;
                traverse.pre.next = current;
                current.next = traverse;
                traverse.pre = current;
                tag = true;
                break;
            }
            traverse = traverse.next;
        }
        if (tag == false) {
            // ins到最尾端
            System.out.println("insert to tail:" + current.companyName);
            Node temp = tail.pre;
            tail.pre = current;
            current.next = tail;
            current.pre = temp;
            temp.next = current;
        }
    }
    public static void topK() {
        Node cur = head.next;
        while (cur != tail) {
            System.out.println(cur.companyName + ": " + cur.price);
            cur = cur.next;
        }
    }
    
    
    
    
}