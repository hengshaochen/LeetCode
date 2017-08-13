public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) { return false; }
        // 條件1: N點有N-1條邊
        // 但是就算有N-1也不一定連通, 還要符合條件2
        if (n - 1 != edges.length) { return false; }
        
        Map<Integer, Set<Integer>> graph = initGraph(n, edges);
        
        // 條件2: 樹為全連通 --> BFS, 若hash size和n相等代表全連通
        // hashSize == n 代表起點可以連通到所有圖上的點
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> hashset = new HashSet<Integer>();
        q.add(0);
        hashset.add(0);
        
        while (!q.isEmpty()) {
            int currentNode = q.remove();
            // 找和currentnNode相鄰的點
            for (Integer neighborNode : graph.get(currentNode) ) {
                // 若這個點已經走訪(標記)過, 不需要再加入set
                if (hashset.contains(neighborNode)) {
                    continue;
                }
                // 若沒走訪, 標記為走訪過
                hashset.add(neighborNode);
                q.add(neighborNode);
            }
        }
        return n == hashset.size();
    }
    
    private Map<Integer, Set<Integer>> initGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
      
        // 將點放入graph
        for (int i = 0; i < n ; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        // 將邊放入graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v); // ex: node 0 的邊集合加入1
            graph.get(v).add(u); // ex: node 1 的邊集合加入0
        }
        return graph;
    }
}