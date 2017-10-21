public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] ans = {-1, -1};
        if (A.length == 0 || A == null) { return ans; }
        
        // find left bound
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            ans[0] = start;
            
        } else if (A[end] == target) {
            ans[0] = end;
            
        } 
        // find right bound
        start = 0;
        end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
            
        }
        if (A[end] == target) {
            ans[1] = end;
        } else if (A[start] == target) {
            ans[1] = start;
        }
        
        return ans;
    }
}
