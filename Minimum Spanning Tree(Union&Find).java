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
    int n = 0;
    public class UFS {
        int[] f;

        // 建構子
        public UFS(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = -1;
            }
        }
        // 把a,b元素的兩個集合 合併成一個集合
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (f[a] < f[b]) { // a set > b set --> 把b合併到a
                f[a] += f[b];
                f[b] = a;
            } else { // a set < b set --> 把a合併到b
                f[b] += f[a];
                f[a] = b;
            }
        }
        // 回傳x所在集合的父親
        public int find(int x) {
            if (f[x] < 0) {
                return x;
            }
            return find(f[x]);
        }
    }
    
    public List<Connection> lowestCost(List<Connection> connections) {

        List<Connection> ans = new ArrayList<>();
        UFS ufs = new UFS(connections.size() * 2);
        
        // 克魯斯卡演算法
        // 排序邊 由小到大
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost) {
                    return a.cost - b.cost;
                }
                // 兩組邊的cost相同, 若city1也都相同, 回傳city2中, 英文字母比較小的
                if (a.city1.equals(b.city1)) {
                    return a.city2.compareTo(b.city2); 
                }
                // 兩組邊的cost相同, 但city1不同, 回傳英文字母比較小的city
                // 例如[B,C,2] [A,C,2] 選[A,C,2]
                return a.city1.compareTo(b.city1); 
            }
        });
       
        // 選邊並加入在不成為cycle前提下最小的邊
        for (Connection item : connections) {
            int c1 = getID(item.city1);
            int c2 = getID(item.city2);
            if (ufs.find(c1) != ufs.find(c2)) {
                ans.add(item);
                ufs.union(c1, c2);
            }
        }
        
        if (ans.size() == n - 1) {
            return ans;
        } else {
            return new ArrayList<>();
        }
    }
    
    Map<String, Integer> name2ID = new HashMap<>();

    public int getID(String name) {
        if (name2ID.containsKey(name)) {
            return name2ID.get(name);
        } else {
            name2ID.put(name, n++);
            return n - 1;
        }
    }
    
}