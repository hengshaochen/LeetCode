public class TwoSum {
    // ArrayList存目前有的值, 
    // Map存前一次的值：<key, value> = <數值, index>
    HashMap<Integer, Boolean> map = new HashMap<>();
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, true);
        } else {
            map.put(number, false);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Integer i : map.keySet()) {
            if (map.containsKey(value - i)) {
                // Case1 : 當前值 == 差值, 確認有2個當前值, ex: 2, 3 | target = 4
                if (i == (value - i)) {
                    if (map.get(i) == true) {
                        return true;
                    }
                // Case2 : 當前值 != 差值, 直接true, ex: 2, 3 | target = 5
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);