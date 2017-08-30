class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
     
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int ptrA = m - 1, ptrB = n - 1, ptrResult = m + n - 1;
        
        while (ptrA >= 0 && ptrB >= 0) {
            if (A[ptrA] > B[ptrB]) {
                A[ptrResult--] = A[ptrA--];
            } else {
                A[ptrResult--] = B[ptrB--];
            }
        }
        
        /*
        // 這行不需要是因為當A指標還>=0時, 代表前面的東西都不用取代, 都放原本即可
        // 範例: A = [3,4] B = [6,7]
        // 當ptrB = -1時, A = [3,4,6,7] , 但ptrA為1(val = 4), 不需要覆蓋
        while (ptrA >= 0) {
            A[ptrResult--] = A[ptrA--];
        }
        */
        
        while (ptrB >= 0) {
            A[ptrResult--] = B[ptrB--];
        }
    }
}
