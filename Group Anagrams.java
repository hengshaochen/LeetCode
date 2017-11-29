class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 建立一個HashMap, key是string, value是該string的答案arraylist
        // 針對每一個String排序, 若排序後的字在hashmap中, 則加入, 不在則新增至map中
        List<List<String>> ans = new ArrayList<>();
        
        // Arrays.sort不支援String, 要用char
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            String sorted_string = new String(cur);
            if (!map.containsKey(sorted_string)) {
                List<String> newlist = new ArrayList<>();
                newlist.add(strs[i]);
                map.put(sorted_string, newlist);
            } else {
                map.get(sorted_string).add(strs[i]);
            }
        }
        
        // 遍歷hashmap放到答案中
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}