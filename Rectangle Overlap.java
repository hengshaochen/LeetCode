/**
 * Definition for a point.
 * class Point {
 *     public int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param l1 top-left coordinate of first rectangle
     * @param r1 bottom-right coordinate of first rectangle
     * @param l2 top-left coordinate of second rectangle
     * @param r2 bottom-right coordinate of second rectangle
     * @return true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // 上下不重疊
        if (l1.y < r2.y || l2.y < r1.y) {
            return false;
        }
        // 左右不重疊
        if (r1.x < l2.x || r2.x < l1.x) {
            return false;
        }
        return true;
    }
}