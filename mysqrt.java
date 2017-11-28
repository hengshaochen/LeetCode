// O(n^0.5)
class Solution {
    public int mySqrt(int x) {
        long ans = 1;
        
        while (ans * ans <= x) {
            ans += 1;
        }
        
        return (int) ans - 1;
    }
}

// binary search: O(logn)
class Solution {
    public int mySqrt(int x) {
        // 把這個問題轉成binary search, 要在1~x中找到一個數字, 該數字^2 會> x的
        long start = 1;
        long end = x;
        
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long cur = mid * mid;
            // cur >= x 代表目標一定在現在end的左邊或是end
            if (cur >= x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        // 先看end若end符合就回傳end, 因為end符合就不可能是start, 因start一定也符合 start * start < x的條件
        if (end * end <= x) {
            return (int)end;
        }
        return (int)start;
        
    }
}