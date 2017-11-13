class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // 每次通過Bianry Search刪除一半的元素 --> O(logn)
        // 如果比前面大, 代表在上坡階段, 後面一定有peak : start = mid
        // 如果比前面小, 代表在下坡階段, 前面一定有peak : end = mid
        /*
        0 1 2 3 4 5 6 7
        1 2 1 3 4 5 7 6
                    l r
        */
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= A[mid - 1]) {
                // 注意要有等號, 等號也不是上坡 [1,1,1,3,2]
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] > A[end]) {
            return start;
        }
        return end;
    }
}
