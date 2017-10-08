/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */


public class Solution {
    /*
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) { return ans; }
        
        // 一次比較n-1和n, n-1.end >= n.start 合併
        // 合併方式：n-1和n 四個可能取最小與最大
        
        // 用左端點排序確保能只需比較右端點就可以確認是否需要合併
        // ex: [2,5] [1,8] 排序後[1,8] [2,5] --> 合併後 [1,8]
        Comparator<Interval> cmp = new Comparator<Interval>() {
            public int compare(Interval e1, Interval e2) {
                return e1.start - e2.start;
            }
        };
        Collections.sort(intervals, cmp);
        
        Interval pre = intervals.get(0);
        for (Interval cur : intervals) {
            if (pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                ans.add(pre);
                pre = cur;
            }
        }
        
        // 加入最後一個至ans中
        ans.add(pre);
        
        return ans;
    }
}