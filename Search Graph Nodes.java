/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // BFS, 找到和target相等則回傳
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        HashSet<UndirectedGraphNode> nodeSet = new HashSet<UndirectedGraphNode>();
        q.add(node);
        nodeSet.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode currentNode = q.remove();
            if (values.get(currentNode).intValue() == target) {
                return currentNode;
            }
            for (UndirectedGraphNode n : currentNode.neighbors) {
                if (!nodeSet.contains(n)) {
                    q.add(n);
                    nodeSet.add(n);
                }
            }
        }
        return null;
    }
}