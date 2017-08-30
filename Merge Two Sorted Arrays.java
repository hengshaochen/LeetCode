public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int aP = 0, bP = 0, mergeP = 0;
        int[] merge = new int[A.length + B.length];
        
        // 兩個皆不為空才需要比大小
        while (aP < A.length && bP < B.length) {
            if (A[aP] > B[bP]) {
                merge[mergeP++] = B[bP++]; 
            } else {
                merge[mergeP++] = A[aP++];
            }
        }
        
        // 還沒放完的放入merge
        while (aP < A.length) {
            merge[mergeP++] = A[aP++];
        }
        while (bP < B.length) {
            merge[mergeP++] = B[bP++];
        }
        
        return merge;
    }
};