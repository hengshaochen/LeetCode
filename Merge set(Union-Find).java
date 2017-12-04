import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        new Solution();
    }
    
    public Solution() {
        List<List<Integer>> set = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        cur.add(2);
        set.add(new ArrayList<>(cur));
        cur.clear();
        cur.add(2);
        cur.add(3);
        set.add(new ArrayList<>(cur));
        cur.clear();
        cur.add(3);
        cur.add(4);
        set.add(new ArrayList<>(cur));
        cur.clear();
        cur.add(5);
        cur.add(6);
        cur.add(7);
        cur.add(8);
        set.add(new ArrayList<>(cur));
        cur.clear();
        cur.add(9);
        set.add(new ArrayList<>(cur));
        cur.clear();
        cur.add(9);
        set.add(new ArrayList<>(cur));
        cur.clear();
        
        merge(set);
    }

    void merge(List<List<Integer>> set) {
        /*
        {1,2},{2,3},{3,4},{5,6,7,8},{9},{9}
         Map: key: point value, value: point's father
         (key, value) = 1, 1
         (key, value) = 2, 1
                      = 3, 1
                      = 4, 1
                      -------
                      = 5, 5
                      = 6, 5
                      = 7, 5
                      = 8, 5
                      -------
                      = 9, 9
        HashMap<Set value, Set> 
        
        {1,2,3,4} {5,6,7,8} {9}
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < set.size(); i++) {
            // 1. find father in this set
            int father = -1;
            for (int j = 0; j < set.get(i).size(); j++) {
                if (map.get(set.get(i).get(j)) != null) {
                    father = map.get(set.get(i).get(j));
                }
            }
            
            // 2. build map
            for (int j = 0; j < set.get(i).size(); j++) {
                if (father != -1) {
                    // father find, point to father
                    map.put(set.get(i).get(j), father);
                } else {
                    // father no find, use set's first element as father
                    map.put(set.get(i).get(j), set.get(i).get(0));
                }
            }
        }
        // 3. Ans set
        // key, value
        // 1, [1,2,3,4]
        // 5, [5,6,7,8]
        // 9, [9]
        HashMap<Integer, Set<Integer>> ansMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!ansMap.containsKey(entry.getValue())) {
                ansMap.put(entry.getValue(), new HashSet<Integer>());
            }
            ansMap.get(entry.getValue()).add(entry.getKey());
        }
        
        // 4. print ans
        for (Map.Entry<Integer, Set<Integer>> entry : ansMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        
    }
}