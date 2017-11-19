class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        // key, array中的index
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            // 如果當前idx不是最後一個 --> swap
            if (idx < list.size() - 1) {
                map.put(list.get(list.size() - 1), idx);
                list.set(idx, list.get(list.size() - 1));
            }
            // 如果是最後一個, 直接remove, 不需要交換
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int range = list.size();
        
        if (range == 0) {
            return -1;
        }
        return list.get(rand.nextInt(range));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */