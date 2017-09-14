class Main {
    public static void main(String[] args) {
        char[] s = {'d', 'c', 'a', 'x'};

        
        for (int i = 0; i < s.length; i++) {
            for (int j = 1; j < s.length - i; j++) {
                if (s[j - 1] > s[j]) {
                    char temp = s[j - 1];
                    s[j - 1] = s[j];
                    s[j] = temp;
                }
            }
            
        }
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);
        System.out.println(s[3]);
    }
}