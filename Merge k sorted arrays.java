class Main {
    public static void main(String[] args) {
        int arr[][] = new int[][]{
            {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                pq.add(arr[i][j]);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = pq.remove();
                System.out.print(arr[i][j] + " ");
            }
        }
        
        
    }
}