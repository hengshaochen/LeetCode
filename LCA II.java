/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // 1. find Path A to root
        // 2. find Path B to root
        // 3. in the reverse order, find the last common node (7->4 , 
        //                                                  5->7->4) return 7
        
        List<ParentTreeNode> pathA = node2path(A);
        List<ParentTreeNode> pathB = node2path(B);
        
        int a_index = pathA.size() - 1;
        int b_index = pathB.size() - 1;
        
        ParentTreeNode LCA = null;
        
        while (a_index >= 0 && b_index >= 0 && 
               pathA.get(a_index) == pathB.get(b_index)) {
            LCA = pathA.get(a_index);
            a_index--;
            b_index--;
        }
        return LCA;
    }
    
    List<ParentTreeNode> node2path(ParentTreeNode node) {
        List<ParentTreeNode> path = new ArrayList<>();
        
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        
        return path;
    }
}
