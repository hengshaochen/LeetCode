class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> cacheMap = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new LinkedHashMap<Integer, Integer>();
        
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)){
            int tmpValue = cacheMap.get(key);
            cacheMap.remove(key);
            cacheMap.put(key,tmpValue);
            return tmpValue;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            cacheMap.remove(key);
            cacheMap.put(key,value);
            return;
        }
        else if (cacheMap.entrySet().size() >= capacity){
            //remove the first one            
            for(Map.Entry<Integer, Integer> entry : cacheMap.entrySet()) {
                //System.out.println(entry.getKey() + ": " + entry.getValue());
                cacheMap.remove(entry.getKey());
                break;
            }
            cacheMap.put(key,value);
            return;
        }
        else{
            cacheMap.put(key,value);
            return;
        }
    }
}