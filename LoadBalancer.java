public class LoadBalancer {
    HashMap<Integer, Integer> map;
    List<Integer> array;
    Random rand;
    
    public LoadBalancer() {
        map = new HashMap<>();
        array = new ArrayList<>();
        rand = new Random();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        if (!map.containsKey(server_id)) {
            array.add(server_id);
            map.put(server_id, array.size() - 1);
        }
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        if (map.containsKey(server_id)) {
            int remove_idx = map.get(server_id);
            int last_element_idx = array.size() - 1;
            
            map.remove(server_id);
            map.put(array.get(last_element_idx), remove_idx);
            array.set(remove_idx, array.get(last_element_idx));
            array.remove(last_element_idx);
        }
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        return array.get(rand.nextInt(array.size()));
    }
}