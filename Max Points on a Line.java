/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param points: an array of point
     * @return: An integer
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) { return 0; }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int vertical = 0, overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                // 特判：重疊點與垂直點
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        overlap++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                
                int g = gcd(dx, dy);
                dx = dx / g;
                dy = dy / g;
                
                String cur_slope = dx + "/" + dy;
                if (!map.containsKey(cur_slope)) {
                    map.put(cur_slope, 1);
                } else {
                    map.put(cur_slope, map.get(cur_slope) + 1);
                }
                max = Math.max(map.get(cur_slope), max);
            }
            max = Math.max(max, vertical);
            ans = Math.max(ans, max + overlap + 1);
        }
        return ans;
    }
    
    public int gcd(int dx, int dy) {
        if (dy == 0) {
            return dx;
        } else {
            return gcd(dy, dx % dy);
        }
    }
}