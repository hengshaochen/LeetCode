class Main {
    public static void main(String[] args) {
        //StringBuilder s = new StringBuilder("we are i interviewing    now");
        String s = "we are  i interviewing    now";
        char[] nums = s.toCharArray();
        // we are  i interviewing n   ow
        //        i
        //         j
        // we are i  interviewing n   ow
        //         i
        //          j
        // we are i  interviewing n   ow
        //          i
        //           j
        // we are i interviewing n   ow
        
        // I  am ap
             i
              j
        // I am  ap
               i
                j
        // I a m ap
              i
               j
        // I am  ap
               i
                j
                 
        // 當nums[j]和nums[j-1]有一個不是空格時, 和i交換
        // 都是空格, 只移動j
        int i = 1;
        int j = 1;
        while (j < nums.length) {
            System.out.println(j);
            // j和j-1有一個不是空格 --> 交換
            if (j >= 1 && (nums[j] != ' ' || nums[j - 1] != ' ')) {
                char temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                /*
                // 如果換過來的是空格-->再往右
                if (i < nums.length && nums[i] == ' ') {
                    i++;
                }
                */
            }
            j++;
        }
        System.out.println(nums);
    }
}