class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder aExtend = new StringBuilder();
        int ans = 0;
        
        while (aExtend.length() < B.length()) {
            aExtend.append(A);
            ans++;
        }
        
        if (aExtend.toString().contains(B)) {
            return ans;
        }
        if (aExtend.append(A).toString().contains(B)) {
            return ans + 1;
        }
        
        // Can not find the substring contains in A that can construct B
        return -1;
    }
}

// 快速版本：
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        int i = 0;
        for (int j = 0; j < B.length(); j++) {
            if (A.charAt(i) != B.charAt(j)) {
                if (count > 1) {       // already second time: no way to make B from A
                    return -1;
                }
                j = -1;    // try to match j's starting character with next i
            }

            i++;
            if (i == A.length()) {        // one more time of A
                if (j == B.length() - 1) {
                    break;
                }
                count++;
                i = 0;
            }
        }
        return count;
    }
}

///////////////////
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        // 每次更新max可以左右子樹同時使用
        // 但是每次return只能回傳左子樹跟右子樹最長的
        if (root == null) {
            return 0;
        }
        helper(root);
        
        return max;
    }
    
    // 需要寫helper, 定義helper回傳該樹的最長unipath（只能用左右中最長的）
    // 而main function是要回傳（可以用左＋root＋右）的答案
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int left_plus_root = 0;
        int right_plus_root = 0;
        
        if (root.left != null && root.left.val == root.val) {
            left_plus_root = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right_plus_root = right + 1;
        }
        max = Math.max(max, left_plus_root + right_plus_root);
        
        return Math.max(left_plus_root, right_plus_root);
    }
}
// 第二題：正確

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


// 第二題：錯誤
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
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2};
        int[] E = {1, 2, 1, 3, 2, 4, 2, 5};
        
        // build graph(node)
        // map: <Index + 1, Node>
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(i + 1, new Node(A[i]));
        }
        
        // build graph(edge)
        for (int i = 0; i < E.length; i += 2) {
            map.get(E[i]).neighbors.add(map.get(E[i + 1]));
            //map.get(E[i + 1]).neighbors.add(map.get(E[i]));
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
        if (cur.neighbors.size() == 0) {
            return 0;
        }
        //System.out.println("cur: " + cur.label);
        int[] child_label = new int [cur.neighbors.size()];
        int[] child_value = new int[cur.neighbors.size()];
        
        for (int i = 0; i < cur.neighbors.size(); i++) {
            child_label[i] = cur.neighbors.get(i).label;
            child_value[i] = dfs(cur.neighbors.get(i));
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