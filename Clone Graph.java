/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
     // System.out.println(nodes.get(0).label);
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) { return node; }
        // Step1: 將圖中所有點放入ArrayList
        ArrayList<UndirectedGraphNode> nodes = getNode(node);
        
        // Step2: 複製點HashMap<舊, 新>
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = cloneNode(nodes);
        
        // Step3: 複製Edges
        cloneEdge(nodes, mapping);
        
        return mapping.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNode(UndirectedGraphNode node) {
        // BFS走訪所有點
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> nodeSet = new ArrayList<UndirectedGraphNode>();
        q.add(node);
        nodeSet.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode currentNode = q.remove();
            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                // 此次的鄰居node不在arraylist中則加入(去重)(不要有重複的點)
                if (!nodeSet.contains(neighbor)) {
                    nodeSet.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return nodeSet;
    }
    
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> cloneNode(ArrayList<UndirectedGraphNode> nodes) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode i : nodes) {
            mapping.put(i, new UndirectedGraphNode(i.label));
        }
        return mapping;
    }
    
    private void cloneEdge(ArrayList<UndirectedGraphNode> nodes, HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping) {
        // nodes = 所有點的清單
        // mapping = 舊的點和新的點的位置對應關係
        // Algo: 掃所有點的清單, 查表舊的點的neighbor, 複製新的點之neighbor
        for (UndirectedGraphNode currentNode : nodes) {
            for (UndirectedGraphNode n : currentNode.neighbors) {
                mapping.get(currentNode).neighbors.add(mapping.get(n));
            }
        }
    }
}