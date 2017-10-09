/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */


public class Solution {
    /*
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // 特判：intervals為空
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        // 特判：插入為空
        if (newInterval == null) {
            return intervals;
        }
        
        // 插入至正確(依然保持排序)的位置 --> 找newInterval.start < intervals.start
        // 或是目前i已經找到最後一個位置了
        int idx = 0;
        while (idx < intervals.size() && intervals.get(idx).start < newInterval.start) {
            idx++;
        }
        intervals.add(idx, newInterval);
        
        // Merge if need
        return merge(intervals);
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) { return ans; }
        
        Interval pre = intervals.get(0);
        for (Interval cur : intervals) {
            if (pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                ans.add(pre);
                pre = cur; // 把pre指向為新的區間
            }
        }
        // 加入尾巴
        ans.add(pre);
        
        return ans;
    }
}