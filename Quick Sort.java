public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) { return; }
        int left = start;
        int right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            // left找比pivot大, right找比pivot小
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            // 兩指針鎖定後進行swap
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        // 切割成子問題
        quickSort(A, start, right);  // 左邊子問題(right剛剛向左移, 放right)
        quickSort(A, left, end);     // 右邊子問題(left剛剛向右移, 放left)
    } 
}