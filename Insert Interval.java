// Review 11/19
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // Merge Interval follow up --> 先插入在正確位置後(不需要排序, 因為這題是排好序的), 再Merge
        // [1,3] [4,9] [6,11] , insert: [5,9]
        // [1,3] [4,9] "[5,9]" [6,11]
        List<Interval> ans = new ArrayList<>();
        
        // 若intervals為0 --> 直接回傳newInterval
        if (intervals.size() == null) {
            intervals.add(newInterval);
            return intervals;
        }
        // 若newInterval為空 --> 直接回傳原本的intervals
        if (newInterval== null) {
            return intervals;
        }
        
        // Insert
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start >= newInterval.start) {
                intervals.add(i, newInterval);
                break;  // 最多只需要插入一次, 不break的話, 會死循環, 因為i一直增加
            }
        }
        // 插在最後一個位置[1,3][6,9] insert [10,13]
        if (intervals.get(intervals.size() - 1).start < newInterval.start) {
            intervals.add(newInterval);
        }
        
        // Merge
        return merge(intervals);
        
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                // 合併
                pre.end = Math.max(pre.end, cur.end);
            } else {
                ans.add(pre);
                pre = cur;
            }
        }
        ans.add(pre);
        
        return ans;
    }
}

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