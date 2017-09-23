private void bubbleSort(int[] a) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.println();
            for (int j = 1; j < len - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
}