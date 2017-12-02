// Correct Version

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    List<Node> neighbors;
    int label;
    Node(int x) { 
        label = x;
        neighbors = new ArrayList<Node>();
    }
}

public class Solution {
    static int max = 0;
    static HashMap<Node, Boolean> hasBeen = new HashMap<>();
    public static void main(String[] args) {
        int[] A = {1,1,1,1};
        int[] E = {1,2,1,4,3,4};
        
        // build graph(node)
        // map: <Index + 1, Node>
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(i + 1, new Node(A[i]));
            hasBeen.put(map.get(i + 1), false);
        }
        
        // build graph(edge)
        for (int i = 0; i < E.length; i += 2) {
            map.get(E[i]).neighbors.add(map.get(E[i + 1]));
            map.get(E[i + 1]).neighbors.add(map.get(E[i]));
        }
        
        // DFS traversal
        // use dfs to find the neighbor's max value
        dfs(map.get(1));
        
        
        // Answer
        System.out.println("max: " + max);
    }
    
    public static int dfs(Node cur) {
        // label this point already been visited
        hasBeen.put(cur, true);
        
        if (cur.neighbors.size() == 0) {
            return 0;
        }
        
        int[] child_label = new int [cur.neighbors.size()];
        int[] child_value = new int[cur.neighbors.size()];
        
        for (int i = 0; i < cur.neighbors.size(); i++) {
            if (hasBeen.get(cur.neighbors.get(i)) == false) {
                child_label[i] = cur.neighbors.get(i).label;
                child_value[i] = dfs(cur.neighbors.get(i));
            }
        }
        
        List<Integer> max_two_child = new ArrayList<>();
        for (int i = 0; i < child_label.length; i++) {
            if (child_label[i] == cur.label) {
                max_two_child.add(child_value[i] + 1);
            }
        }
        
        // find two largest element in max_two_child
        int max_1 = quickSelect(max_two_child, 1, 0, max_two_child.size() - 1);
        int max_2 = quickSelect(max_two_child, 2, 0, max_two_child.size() - 1);
        
        max = Math.max(max, max_1 + max_2);
        return Math.max(max_1, max_2);
    }

    public static int quickSelect(List<Integer> nums, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int left = start;
        int right = end;
        int pivot = nums.get((start + end) / 2);
        
        while (left <= right) {
            while (left <= right && nums.get(left) > pivot) {
                left++;
            }
            while (left <= right && nums.get(right) < pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums.get(left);
                nums.set(left, nums.get(right));
                nums.set(right, temp);
                left++;
                right--;
            }
        }
        
        // 往左
        if (start + k - 1 <= right) {
            return quickSelect(nums, k, start, right);
        }
        // 往右
        if (start + k - 1 >= left) {
            return quickSelect(nums, k - (left - start), left, end);
        }
        // 剛好是中間的
        return nums.get(right + 1);
    }
    
}

/////// Debug Version
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    List<Node> neighbors;
    int label;
    Node(int x) { 
        label = x;
        neighbors = new ArrayList<Node>();
    }
}

public class Solution {
    static int max = 0;
    static HashMap<Node, Boolean> hasBeen = new HashMap<>();
    public static void main(String[] args) {
        /*
        int[] A = {1,1,1,1,1,1,1,1,1,1,1,1};
        int[] E = {1,2,1,3,1,4,1,5,2,6,2,7,3,8,4,9,4,10,9,11,9,12};
        
        int[] A = {1,1,1,1,1,1,1,1,1,1,1,1};
        int[] E = {1,2,1,3,1,4,1,5,2,6,2,7,3,8,4,9,4,10,9,11,9,12};
        */
        int[] A = {1,1,1,1};
        int[] E = {1,2,1,4,3,4};
        /*
        int[] A = {1,1,1,2,2};
        int[] E = {1,2,1,3,2,4,2,5};
        */
        
        // build graph(node)
        // map: <Index + 1, Node>
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(i + 1, new Node(A[i]));
            hasBeen.put(map.get(i + 1), false);
        }
        
        // build graph(edge)
        for (int i = 0; i < E.length; i += 2) {
            map.get(E[i]).neighbors.add(map.get(E[i + 1]));
            map.get(E[i + 1]).neighbors.add(map.get(E[i]));
        }
        
        // DFS traversal
        // use dfs to find the neighbor's max value
        dfs(map.get(1));
        
        /*
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            System.out.println("Node: " + (entry.getKey()));
            for (Node neighbor : entry.getValue().neighbors) {
                System.out.print(neighbor.label + " ");
            }
            System.out.println();
        }
        */
        
        System.out.println("max: " + max);
    }
    
    public static int dfs(Node cur) {
        // label this point already been visited
        hasBeen.put(cur, true);
        
        if (cur.neighbors.size() == 0) {
            return 0;
        }
        
        //System.out.println("cur: " + cur.label);
        int[] child_label = new int [cur.neighbors.size()];
        int[] child_value = new int[cur.neighbors.size()];
        
        for (int i = 0; i < cur.neighbors.size(); i++) {
            if (hasBeen.get(cur.neighbors.get(i)) == false) {
                child_label[i] = cur.neighbors.get(i).label;
                child_value[i] = dfs(cur.neighbors.get(i));
            }
        }
        
        List<Integer> max_two_child = new ArrayList<>();
        for (int i = 0; i < child_label.length; i++) {
            if (child_label[i] == cur.label) {
                max_two_child.add(child_value[i] + 1);
            }
        }
        
        // find two largest element in max_two_child
        //System.out.println(max_two_child.size());
        int max_1 = quickSelect(max_two_child, 1, 0, max_two_child.size() - 1);
        int max_2 = quickSelect(max_two_child, 2, 0, max_two_child.size() - 1);
        
        max = Math.max(max, max_1 + max_2);
        return Math.max(max_1, max_2);
    }

    public static int quickSelect(List<Integer> nums, int k, int start, int end) {
        //System.out.println("start: " + start + "end: " + end);
        if (start > end) {
            return 0;
        }
        int left = start;
        int right = end;
        int pivot = nums.get((start + end) / 2);
        
        while (left <= right) {
            while (left <= right && nums.get(left) > pivot) {
                left++;
            }
            while (left <= right && nums.get(right) < pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums.get(left);
                nums.set(left, nums.get(right));
                nums.set(right, temp);
                left++;
                right--;
            }
        }
        
        // 往左
        if (start + k - 1 <= right) {
            return quickSelect(nums, k, start, right);
        }
        // 往右
        if (start + k - 1 >= left) {
            return quickSelect(nums, k - (left - start), left, end);
        }
        // 剛好是中間的
        return nums.get(right + 1);
    }
    
}