/*
 * Complete the function below.
 */

    static int countPairs(int k, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for  (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


/*
 * Complete the function below.
 */

    static boolean isAnagram(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < str1.length(); i++) {
            char cur = str1.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur).intValue() + 1);
            }
        }
        
        for (int i = 0; i < str2.length(); i++) {
            char cur = str2.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur).intValue() - 1);
            }
        }
        
        for (Character cur : map.keySet()) {
            if (map.get(cur).intValue() != 0) {
                return false;
            }
        }
        return true;
    }


/*
 * Complete the function below.
 */

    static boolean isAnagram(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < str1.length(); i++) {
            char cur = str1.charAt(i);
            if (!map1.containsKey(cur)) {
                map1.put(cur, 1);
            } else {
                map1.put(cur, map1.get(cur).intValue() + 1);
            }
            
            char cur2 = str2.charAt(i);
            if (!map2.containsKey(cur2)) {
                map2.put(cur2, 1);
            } else {
                map2.put(cur2, map2.get(cur2).intValue() + 1);
            }
        }
        
        for (Character cur : map1.keySet()) {
            if (map2.get(cur) == null || map1.get(cur).intValue() != map2.get(cur).intValue()) {
                return false;
            }
        }
        return true;
    }

