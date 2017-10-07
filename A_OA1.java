class Main {
    public static void main(String[] args) {
        String a = "ABIJ DEHI MNQR STWX";
        
        // 建立字母對應關係
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (Character cur = 'A'; cur <= 'Z'; cur++) {
            map.put(cur, count++);
        }
        
        for (int i = 0; i < a.length(); i++) {
            System.out.print(map.get(a.charAt(i)) + " ");
        }
    }
}