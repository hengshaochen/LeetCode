// 兩指標 + HashMap --> 邊做邊覆蓋
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // 法1: HashMap<Key, Value> = <Value, Index> , 因為value不能重複,
        // 定義replacePtr: 在此指標之前的都是排好的, 這個指標就是要被蓋的
        // 掃一次, 若沒contain, 則加入hashmap, 同時把nums[i] 放到replacePtr[i]中
        // 若有contain, 則不加入map, 同時覆蓋指標(replacePtr)不動, i繼續順著迴圈往前
        // *i會跑得比replacePtr快
        
        if (nums == null || nums.length == 0) { return 0; }
        HashMap<Integer, Integer> map = new HashMap<>();
        int replacePtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],replacePtr);
                nums[replacePtr] = nums[i];
                replacePtr = replacePtr + 1;
            }
        }
        return map.size();
    }
}

// 不用指標 Time: O(n) Space: O(n) , 建立完HashMap再進行覆蓋
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // 法1: HashMap<Key, Value> = <Value, Index> , 因為value不能重複,
        // 把不重複的放到map, 然後覆蓋array即可
        
        if (nums == null || nums.length == 0) { return 0; }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }
        }
        int counter = 0;
        for (Integer k : map.keySet()) {
            nums[counter++] = k;
        }
        
        return map.size();
    }
}

// 兩指標, 沒有額外空間 Time: O(nlogn) Space: O(1)
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // 法2: 先進行排序O(nlogn), 所有重複的數字都會黏再一起, 所以指標只要in place掃一次就可以偵測到是否有重複, 因為1,1,2,3, 不會是1,3,2,1, 這樣重複的一定在旁邊, 指標一直向右移動可以找到所有重複的
        // Algo: replacePtr指向重複的元素的前一個, 要把指標i的值蓋到++replacePtr中
        // init i = 0, replacePtr = 1
        // 若不相等, 則覆蓋, 若相等i繼續跑
        if (nums == null || nums.length == 0) { return 0; }
        Arrays.sort(nums);
        int replacePtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[replacePtr]) {
                nums[++replacePtr] = nums[i];
            }
        }
        return replacePtr + 1;
    }
}
