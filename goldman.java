// 1.
class Main {
    public static void main(String[] args) {
        String s = "caaab";
        int k = 2;
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < s.length() - 1; i++) {
            String cur = s.substring(i, i + k);
            if (!set.contains(cur)) {
                set.add(cur);
                list.add(cur);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        
    }
}

// 2.
class Main {
    public static void main(String[] args) {
    class Point {
        int scores;
        int count;
        Point(int scores, int count) {
            this.scores = scores;
            this.count = count;
        }
    }
        // class Point: total_score, count
        // Map<Name, Point>
        // 思路：掃一遍table, 每次把total_score加上當前score, count++
        String[][] table = new String[3][2];
        table[0][0] = "Henry";
        table[0][1] = "100";
        table[1][0] = "Henry";
        table[1][1] = "-200";
        table[2][0] = "Ge";
        table[2][1] = "85";

        HashMap<String, Point> map = new HashMap<>();                           
        //map.put(table[0][0], new Point(Integer.parseInt(table[0][1]), 1));

        Point a = new Point(1,2);
        HashMap<String, Point> map2 = new HashMap<>();
        /*map2.put(table[0][0],new Point(2,3));
        map2.get(table[0][0]).scores = 10;
        System.out.println(map2.get(table[0][0]).scores);*/
        
        for (int i = 0; i < table.length; i++) {
            if (!map.containsKey(table[i][0])) {
                map.put(table[i][0], new Point(Integer.parseInt(table[i][1]), 1));
            } else {
                map.get(table[i][0]).scores = map.get(table[i][0]).scores +                                 Integer.parseInt(table[i][1]);
                
                map.get(table[i][0]).count = map.get(table[i][0]).count + 1;
            }
            
        }
        
        // 掃一遍map算平均, 並加入一個max_value同時挑戰
        int max_avg = Integer.MIN_VALUE;
        for (String cur : map.keySet()) {
            int current_avg = map.get(cur).scores / map.get(cur).count;
            if (current_avg > max_avg) {
                max_avg = current_avg;
            }
        }
        
        System.out.println(max_avg);
    }
}

// 2. Double Version
class Main {
    /*
        int a = -123;
        double b = -123;
        System.out.println(a / 10); ans: -12
        System.out.println((int) Math.floor(b / 10));  ans: -13 correct
    */
    
    public static void main(String[] args) {
    class Point {
        double scores;
        int count;
        Point(double scores, int count) {
            this.scores = scores;
            this.count = count;
        }
    }
        // class Point: total_score, count
        // Map<Name, Point>
        // 思路：掃一遍table, 每次把total_score加上當前score, count++
        String[][] table = new String[3][2];
        table[0][0] = "Henry";
        table[0][1] = "100";
        table[1][0] = "Henry";
        table[1][1] = "-200";
        table[2][0] = "Ge";
        table[2][1] = "85";

        HashMap<String, Point> map = new HashMap<>();                           
        //map.put(table[0][0], new Point(Integer.parseInt(table[0][1]), 1));

        Point a = new Point(1,2);
        HashMap<String, Point> map2 = new HashMap<>();
        /*map2.put(table[0][0],new Point(2,3));
        map2.get(table[0][0]).scores = 10;
        System.out.println(map2.get(table[0][0]).scores);*/
        
        for (int i = 0; i < table.length; i++) {
            if (!map.containsKey(table[i][0])) {
                map.put(table[i][0], new Point(Double.parseDouble(table[i][1]), 1));
            } else {
                map.get(table[i][0]).scores = map.get(table[i][0]).scores +                                 Double.parseDouble(table[i][1]);
                
                map.get(table[i][0]).count = map.get(table[i][0]).count + 1;
            }
            
        }
        
        // 掃一遍map算平均, 並加入一個max_value同時挑戰
        double max_avg = Double.MIN_VALUE;
        for (String cur : map.keySet()) {
            double current_avg = map.get(cur).scores / map.get(cur).count;
            current_avg = Math.floor(current_avg);
            if (current_avg > max_avg) {
                max_avg = current_avg;
            }
        }
        
        System.out.println((int) max_avg);
    }
}

// 3.
class Solution {
    public int climbStairs(int n) {
        // f[n] = f[n-1] + f[n-2]
        // f[0] = 1, f[1] = 1
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }
        
        return f[n];
    }
}

// 4. K-select

// 5.
class Solution {
    public int firstUniqChar(String s) {
        // use hashmap, scan 1 times
        //HashMap<Character, Integer> map = new HashMap<>();
        int[] map = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] += 1;
        }
        
        // scan again, and get the cur char value in map 
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) {
                return i;
            }    
        }
        
        return -1;
    }
}

// 6.
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!smap.containsKey(s.charAt(i))) {
                smap.put(s.charAt(i), 1);
            } else {
                smap.put(s.charAt(i), smap.get(s.charAt(i)) +1);
            }
            
            if (!tmap.containsKey(t.charAt(i))) {
                tmap.put(t.charAt(i), 1);
            } else {
                tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
            }
        }
        
        for (Character cur : smap.keySet()) {
            if (tmap.get(cur) == null || smap.get(cur).intValue() != tmap.get(cur).intValue()) {   // 記得改成intValue()
                return false;
            }
        }
        
        return true;
    }
}

// 7.
class Main {
    public static void main(String[] args) {
        List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur_a = new ArrayList<>();
        
        cur_a.add(1);
        cur_a.add(2);
        cur_a.add(3);
        a.add(new ArrayList(cur_a));
        cur_a.clear();
        cur_a.add(1);
        cur_a.add(2);
        cur_a.add(1);
        a.add(new ArrayList(cur_a));
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        
        
        List<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur_b = new ArrayList<>();
        
        cur_b.add(4);
        cur_b.add(5);
        cur_b.add(6);
        b.add(new ArrayList(cur_b));
        cur_b.clear();
        cur_b.add(2);
        cur_b.add(2);
        cur_b.add(2);
        b.add(new ArrayList(cur_b));
        System.out.println(b.get(0));
        System.out.println(b.get(1));
        
        int product = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                product = product + a.get(i).get(j) * b.get(i).get(j);
            }
        }
        
        System.out.println(product);
    }
}

// 8.
public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        
        while (l < r) {
            int sum = nums[l] + nums[r];
            
            if (sum == target) {
                count++;
                
                l++;
                r--;
                
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
            
        }
        return count;
        
    }
    
    
}

// 9.
class Main {
    public static void main(String[] args) {
        String s = "cccccaaabbb";
        String ans = "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1); 
            } else {
                map.put(cur, 1);
            }
        }
        /*
        for (Character cur : map.keySet()) {
            ans = ans + cur + map.get(cur);
        }
        */
        for (Map.Entry<Character, Integer> cur : map.entrySet()) {
            ans = ans + cur.getKey() + cur.getValue();
        }
        
        System.out.println(ans);
    }
}

// 10.
public class Solution {
    public String reverseWords(String s) {
        String ans = "";
        
        String[] sp = s.split(" ");
        for (int i = sp.length - 1; i >= 0; i--) {
            if (!sp[i].equals("")) {
                ans = ans + ' ' + sp[i];
            }
        }
        
        if (ans.length() == 0) { 
            return ans; 
        }
        return ans.substring(1, ans.length());
    }
}