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
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // 法1: 用min_heap 全部丟進去, 取最小的就可（heap size會很大)

        PriorityQueue<Point> min_heap = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(a, origin) - getDistance(b, origin);
                if (diff == 0)
                    diff = a.x - b.x;
                if (diff == 0)
                    diff = a.y - b.y;
                return diff;
            }
        });
        
        for (int i = 0; i < points.length; i++) {
            min_heap.add(points[i]);
        }
        
        Point[] ans = new Point[k];
        
        for (int i = 0; i < k; i++) {
            ans[i] = min_heap.poll();
        }
        
        return ans;
    }
    
    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}