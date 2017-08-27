public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) { return; }
        int left = start;
        int right = end;
        int mid = (start + end) / 2;
        
        // 切割
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);
        //合併
        merge(A, start, mid, end, temp);
    }
    private void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;
        
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        // 將剩餘的擺入temp
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        
        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }
}