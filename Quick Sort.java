public class Solution {
    /*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers2(int[] A) {
        // 兩個指標, left找比pivot大的, right找比pivot小的, 每回合swap完畢後, 左邊都會比pivot小, 右邊會比pivot大 --> 切割成子問題
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) { return; }
        int left = start;
        int right = end;
        // 下面會出錯, 因為pivot有可能會被換掉, 之後指向他index的值就會變化
        //int pivotIdx = (start + end) / 2;
        int pivot = A[(start + end) / 2];
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            
            while (left <= right && A[right] > pivot) {
                right--;
            }
            
            // Swap
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
