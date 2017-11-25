class Main {
    public static void main(String[] args) {
        /*List<Set<Integer>> sets = new ArrayList<Set<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        */
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
        
        
        //combineSet(new int[][]{ {1,2}, {2,3}, {3,4}, {5,6,7,8}, {9}, {9} });
        combineSet(set);
    }
    
    
    public static void combineSet(List<List<Integer>> set) {
        // 建(Union-and-Find): 如果兩個在不同set, 小的合併到大的
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 掃這整個子set, 看有沒有已經是個set的
        // 如果沒有, 則取第一個當成set的頭, 如果有, 則把其他人連到這個有的人身上
        for (int i = 0; i < set.size(); i++) {
            int father = -1;
            for (int j = 0; j < set.get(i).size(); j++) {
                if (map.get(set.get(i).get(j)) != null) {
                    father = map.get(set.get(i).get(j));
                }
            }
            for (int j = 0; j < set.get(i).size(); j++) {
                if (father != -1) {
                    map.put(set.get(i).get(j), father);
                } else {
                    map.put(set.get(i).get(j), set.get(i).get(0));
                }
            }
            
        }
        /*
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
        */
        
        // 將做完Union後, Union結構的答案放到Set中
        // 用HashMap, 每個類別對應一個Set
        Map<Integer, Set<Integer>> ans = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!ans.containsKey(entry.getValue())) {
                ans.put(entry.getValue(), new HashSet<Integer>());
            }
            ans.get(entry.getValue()).add(entry.getKey());
        }
        
        // 列印答案
        for (Map.Entry<Integer, Set<Integer>> entry : ans.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    
}