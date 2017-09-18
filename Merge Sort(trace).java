public class Solution {
    /*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers2(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    public void mergeSort(int[] A, int start, int end, int[] temp) {
        // 先切割, 再合併
        if (start >= end) { return; }
        int mid = (start + end) / 2;
        
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);
        merge(A, start, mid, end, temp);
    }
    public void merge(int[] A, int start, int mid, int end, int[] temp) {
        System.out.println("start: " + start + " end: " + end);
        int left = start;
        int right = mid + 1;
        int index = start;
        
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[start++] = A[left++];
            } else {
                temp[start++] = A[right++];
            }
        }
        
        while (left <= mid) {
            temp[start++] = A[left++];
        }
        while (right <= end) {
            temp[start++] = A[right++];
        }
        
        for (int i = 0; i <= end; i++) {
            System.out.println("i:" + i + " = " + temp[i]);
            A[i] = temp[i];
        }
    }
}