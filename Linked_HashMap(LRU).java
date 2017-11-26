    public static void LRU_LinkedHashMap() {
        // 將Linked_HashMap第三個參數設為accessOrder = true
        int cap = 3;
        Map<String, String> map = new LinkedHashMap<String, String>(cap, 0.75f, true)         {
            // 自行重載remove的規則：當size() > cap, 則刪除最老的（list的頭）
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest)             {
                return size() > cap;
            }
        };

        map.put("HBO", "HBO");
        map.put("MTV", "MTV");
        map.put("NBC", "NBC");
        // 在數據中是長：HBO->MTV->NBC
        System.out.println(getK(map));
        System.out.println("");

        map.get("HBO");
        map.put("FOX", "FOX");
        // 在數據中是長：NBC->HBO->FOX
        System.out.println(getK(map));
    }
    public static List<String> getK(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(0, entry.getValue());
        }
        return list;
    }