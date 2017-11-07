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

/*
Review: 9/27



public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> nodeSet = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        // 走訪每一個node, 把所有node存在arrayList
        nodeSet = getNode(node);
        
        for (UndirectedGraphNode cur : nodeSet) {
            System.out.println(cur.label);
        }
        
        // 複製node, 且新舊node用hashmap對應 <old, new>
        mapping = cloneNode(nodeSet);
        
        // 複製邊
        cloneEdge(nodeSet, mapping);
        
        return mapping.get(node);
    }
    
    public void cloneEdge(ArrayList<UndirectedGraphNode> nodeSet, HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping) {
        // 要給新的點附上邊, 掃一次所有的點, 根據old的neighbor給 new附上邊
        for (UndirectedGraphNode cur : nodeSet) {
            for (UndirectedGraphNode curNeighbor : cur.neighbors) {
                mapping.get(cur).neighbors.add(mapping.get(curNeighbor));
            }
        }
        
    }
    
    public HashMap<UndirectedGraphNode, UndirectedGraphNode> cloneNode(ArrayList<UndirectedGraphNode> nodeSet) {
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        
        for (UndirectedGraphNode cur : nodeSet) {
            mapping.put(cur, new UndirectedGraphNode(cur.label));
        }
        
        return mapping;
    }
    
    public ArrayList<UndirectedGraphNode> getNode(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> nodeSet = new ArrayList<>();
        
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        if (node != null) { 
            q.add(node);
            nodeSet.add(node);
        }
        
        // BFS
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.remove();
            
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                // 要使用nodeSet當條件, 若用q, 會造成刪除後, 又加入又走訪一遍
                // 圖和樹的差異在於: 圖可能會走訪回已經走訪過得點
                if (!nodeSet.contains(neighbor)) {
                    q.add(neighbor);
                    nodeSet.add(neighbor);
                }
            }
        }
        
        return nodeSet;
    }
}
*/

/*
Review: 11/06 No ArrayList Space
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) { return null; }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        
        q.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.remove();
            
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    q.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}