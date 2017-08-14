/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    ArrayList<DirectedGraphNode> sort = new ArrayList<>();
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph)
    {
        // Step1: 統計每個node的indegree 用hashMap
        HashMap<DirectedGraphNode, Integer> inDegreeMap = countInDegree(graph);
        
        // Step2: 找起點(indegree為0的都可為起點)
        Queue<DirectedGraphNode> q = getStartNode(inDegreeMap, graph);
        
        // Step3: 由起點走訪, 走訪到的就把起點相鄰的indegree - 1
        BFS(inDegreeMap, graph, q);
        
        return sort;
    }
    private HashMap<DirectedGraphNode, Integer> countInDegree(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            DirectedGraphNode currentNode = node;
            for (DirectedGraphNode neighbor : currentNode.neighbors) {
                if (inDegreeMap.containsKey(neighbor)) {
                    inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) + 1);
                } else {
                    inDegreeMap.put(neighbor, 1);
                }
            }
        }
        return inDegreeMap;
    }
    private Queue<DirectedGraphNode> getStartNode(HashMap<DirectedGraphNode, Integer> inDegreeMap, ArrayList<DirectedGraphNode> graph) {
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (DirectedGraphNode currentNode : graph) {
            if(!inDegreeMap.containsKey(currentNode)) {
                q.add(currentNode);
                sort.add(currentNode);
            }
        }
        return q;
    }
    private void BFS(HashMap<DirectedGraphNode, Integer> inDegreeMap, ArrayList<DirectedGraphNode> graph, Queue<DirectedGraphNode> q) {
        // 由起點開始(q裡面的node), 找鄰居, 將鄰居的indegree - 1
        // 若鄰居的indegree = 0 , 放到sort,q
        while (!q.isEmpty()) {
            DirectedGraphNode currentNode = q.remove();
            for (DirectedGraphNode neighbor : currentNode.neighbors) {
                inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) - 1);
                if (inDegreeMap.get(neighbor).intValue() == 0) {
                    sort.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
    }
}