// Review 12/3
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // key: vertical #, value: arraylist
        /*
        0: 301
        -1: 9
        -2: 4
         1: 8
         2: 7
        */
         // Vertical Number, # vertical number element set
         HashMap<Integer, ArrayList<Integer>> ans_map = new HashMap<>();
         
         // TreeNode, Vertical Number
         HashMap<TreeNode, Integer> map = new HashMap<>();
         
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         map.put(root, 0);
         
         int min_vertical = 0;
         int max_vertical = 0;
         
         while (!q.isEmpty()) {
             int qsize = q.size();
             for (int i = 0; i < qsize; i++) {
                 TreeNode cur = q.remove();
                 int current_vertical_number = map.get(cur);
                 if (!ans_map.containsKey(current_vertical_number)) {
                     ans_map.put(map.get(cur), new ArrayList<>());
                 }
                 ans_map.get(current_vertical_number).add(cur.val);
                 
                 // 維護到時輸出答案的最小最大值
                 if (current_vertical_number < min_vertical) {
                     min_vertical = current_vertical_number;
                 }
                 if (current_vertical_number > max_vertical) {
                     max_vertical = current_vertical_number;
                 }
                 
                 // add left and right node to queue
                 if (cur.left != null) {
                     q.add(cur.left);
                     map.put(cur.left, map.get(cur) - 1);
                 }
                 if (cur.right != null) {
                     q.add(cur.right);
                     map.put(cur.right, map.get(cur) + 1);
                 }
             }
         }
         
         for (int i = min_vertical; i <= max_vertical; i++) {
             ans.add(ans_map.get(i));
         }
         
         return ans;
    }
}


////////////////////////////////////////
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) { return new ArrayList<>(); }
        
        // 讓TreeNode可以對應到他的vertical number
        HashMap<TreeNode, Integer> map = new HashMap<>();
        // vertical number對應到ans arraylist
        HashMap<Integer, ArrayList<Integer>> ans_map = new HashMap<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root, 0);
        
        // 維護這兩個變數, 讓最後輸出能照vertical order輸出
        int min_v = 0;
        int max_v = 0;
        
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                TreeNode cur = q.remove();
                int cur_vertical = map.get(cur);
                
                // 第一次的cur_vertical, 開闢空間
                if (!ans_map.containsKey(cur_vertical)) {
                    ans_map.put(cur_vertical, new ArrayList<Integer>()); 
                }
                // 將cur.val加入至對應到的vertical
                ans_map.get(cur_vertical).add(cur.val);
                
                // 往左右走訪, vertical往左-1, 往右+1
                if (cur.left != null) {
                    q.add(cur.left);
                    map.put(cur.left, cur_vertical - 1);
                    
                    min_v = (min_v > cur_vertical - 1) ? cur_vertical - 1 : min_v;
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    map.put(cur.right, cur_vertical + 1);
                    
                    max_v = (max_v < cur_vertical + 1) ? cur_vertical + 1 : max_v;
                }
            }
        }
        // 走訪整個hashmap, 將答案放入ans
        for (int i = min_v; i <= max_v; i++) {
            ans.add(ans_map.get(i));
        }
        return ans;
    }   
}