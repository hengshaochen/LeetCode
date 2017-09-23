/**
 * Created by henrychen on 2017/9/22.
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] a = {23,7,10,40};

        ArraySort sort = new ArraySort();
        sort.printArray(a);
        sort.selectionSort(a);
        sort.printArray(a);


    }

    private void selectionSort(int[] a) {
        // i 為現在要擺放的位置, j 為掃整個
        for (int i = 0; i < a.length; i++) {

            int min = Integer.MAX_VALUE;
            int minIndex = i;

            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


}
