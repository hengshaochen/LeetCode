class Main {
    public static void main(String[] args) {
        // 第一题是给一个无序整数数组（不包含重复），随机选出三个不重复的数字
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        Random random = new Random();
        int size = arr.length;
        for (int i = 0; i < 3; i++) {
            //System.out.println("size;" + size);
            int pick_index = random.nextInt(size);
            //System.out.println(arr[pick_index]);
            arr[pick_index] = arr[size - 1];
            size--;
        }
        
        for (int i = 0; i < arr.length; i++)
           System.out.print(arr[i] + " ");
    }
}