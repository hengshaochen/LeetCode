
/**
Definition for a point.
class Point {
int x;
int y;
Point() { x = 0; y = 0; }
Point(int a, int b) { x = a; y = b; }
}
*/
public class Solution {
/*
* @param points: a list of points
* @param origin: a point
* @param k: An integer
* @return: the k closest points
*/
    public Point[] kClosest(Point[] points, Point origin, int k) {
    // 法2:用max_heap固定heap size為k 每次抓最大的出來跟挑戰者比較
        Comparator<Point> cmp;
        cmp = new Comparator<Point>() {
            public int compare(Point e1, Point e2) {
                int diff = getDistance(e2, origin) - getDistance(e1, origin);
                
                if (diff == 0) {
                    diff = e2.x - e1.x;
                }
                if (diff == 0) {
                    diff = e2.y - e1.y;
                }
                
                return diff;
              }
         };
        Queue<Point> max_heap = new PriorityQueue<>(k, cmp);
        
        for (int i = 0; i < points.length; i++) {
            if (max_heap.size() < k) {
                max_heap.add(points[i]);
            } else if (max_heap.size() == k) {
                Point cur = max_heap.poll();
                int cur_dis = getDistance(cur, origin);
                int new_dis = getDistance(points[i], origin);
                
                if (new_dis < cur_dis) {
                    max_heap.add(points[i]);
                } else {
                    max_heap.add(cur);
                }
            }
        }
        
        k = max_heap.size(); // 把這行加入就不會在points.length < k時run time error, 直接看max_heap有幾個數字就輸出幾個
        Point[] ans = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = max_heap.poll();
        }
        
        return ans;
    }
    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}