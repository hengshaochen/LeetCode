class Main {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"a", "123", "b", "234", "c", "345"};
        String[] arr2 = new String[]{"a", "c"};
        
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        
        int i = 0;
        while (i < arr1.length) {
            if (set.contains(arr1[i])) {
                System.out.println(arr1[i] + " " + arr1[i + 1] + " Y");
                set.remove(arr1[i]);
            } else {
                System.out.println(arr1[i] + " " + arr1[i + 1] + " N");
            }
            i += 2;
        }
    }
}