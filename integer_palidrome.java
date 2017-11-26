    public static boolean integer_palidrome(int n) {
        // 4 = 100 is not a palindrome
        // 把100變成001看是否相等, 耗費O(n)空間
        int ori_n = n;
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 2);
            n = n / 2;
        }
        int count = 0;
        int pow_i = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            count = count + (int)Math.pow(2, pow_i++) * list.get(i);
        }
        
        if (count == ori_n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return count == n;
    }

    // 法2: 空間O(1)
    public static boolean integer_palidrome(int n) {
        // 6 =110 --> 011 = 3
        // 直接用int存, 然後直接反轉, 看反轉後的int和原本的n是否相同

        int rev = 0;
        int ori_n = n;
        while (n != 0) {
            rev = rev * 2;
            rev = rev + (n % 2);
            n = n / 2;
        }
        System.out.println("反轉後的數字：" + rev);

        if (rev == ori_n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return rev == n;
    }