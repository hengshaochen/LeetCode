/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    
    int n = 0; // 記錄ufs的當前該賦予的index (HashMap中使用)
    // Union & Find
    public class UFS {
        int[] f;
        
        // 初始化每個都為父親節點, 且兒子數為1
        public UFS(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = -1;
            }
        }
        
        // 回傳x的父親節點index
        public int find(int x) {
            // 定義value < 0 為父親
            if (f[x] < 0) {
                return x;
            }
            // 如果此node不為父親, 往上面找
            return find(f[x]);
        }
        
        // union(a,b) , 將a和b兩個set合併(小的併入大的)
        public void union(int a, int b) {
            // 獲得a的父親與b的父親
            int root_of_node_a = find(a);
            int root_of_node_b = find(b);
            
            // 獲取父親值比較set大小
            if (f[root_of_node_a] < f[root_of_node_b]) { // 注意是負數, 因此a set > b set --> b併入a
                f[root_of_node_a] = f[root_of_node_a] + f[root_of_node_b];
                f[root_of_node_b] = root_of_node_a;
            } else {
                f[root_of_node_b] = f[root_of_node_b] + f[root_of_node_a];
                f[root_of_node_a] = root_of_node_b;
            }
        }
    }
    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> ans = new ArrayList<>();
        UFS ufs = new UFS(connections.size() * 2);
        HashMap<String, Integer> map = new HashMap<>();
        
        // Step1: 將邊以cost小到大排序, 若遇到相同cost, 取字母小的排前面
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost) {
                    return a.cost - b.cost;
                }
                // 兩組邊的cost相同, 若city1也都相同, 回傳city2中, 英文字母比較小的
                if (a.city1.equals(b.city1)) {
                    return a.city2.compareTo(b.city2); 
                }
                // 兩組邊的cost相同, 但city1不同, 回傳英文字母比較小的city1
                // 例如[B,C,2] [A,C,2] 選[A,C,2]
                return a.city1.compareTo(b.city1); 
            }
        });
        
        // Step2: 在不形成Cycle的情況下選最小邊
        // 若兩個node find出來為同個父親, 則代表再將兩node間加入邊會有cycle
        
        for (Connection cur : connections) {
            int root_of_city1 = string_to_index(cur.city1, map);
            int root_of_city2 = string_to_index(cur.city2, map);
            
            if (ufs.find(root_of_city1) != ufs.find(root_of_city2)) {
                ufs.union(root_of_city1, root_of_city2);
                ans.add(cur);
            }
        }
        
        if (ans.size() == n - 1) {
            return ans;
        }
        return new ArrayList<>();
    }
    
    // 把城市名稱(String) --> UFS中的index (若不存在則put)
    public int string_to_index(String cityName, HashMap<String, Integer> map) {
        if (map.containsKey(cityName)) {
            return map.get(cityName);
        } else {
            map.put(cityName, n++);
            return n - 1;
        }
    }
}