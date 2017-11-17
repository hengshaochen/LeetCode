/*
 * Complete the function below.
 */

    static int countPairs(int k, int[] a) {
        //save to hash map
        HashMap<Integer,Integer> array = new HashMap<Integer,Integer>();
        
        for (int i = 0;i < a.length;i++){
            if (array.containsKey(a[i])){
                int currentNum = array.get(a[i]);
                currentNum++;
                array.put(a[i],currentNum);
            }else{
                array.put(a[i],1);
            }
        }
        //reform a array that base on key
        int size = array.size();
        //int[] nums = new int[size];
        //nums = (int[])array.keySet().toArray(nums);
        List<Integer> nums = new ArrayList<Integer>();
        for (Integer current: array.keySet()){
            nums.add(current);
        }
        Collections.sort(nums);
        for (int i = 0;i<nums.size();i++){
            System.out.print(nums.get(i));
        }
        //approach from both side
        int left = 0;
        int right = nums.size() - 1;//TODO
        int count = 0;
        while(left < right){
            int sum = nums.get(left) + nums.get(right);
            System.out.println(nums.get(left)+" "+nums.get(right));
            if (sum == k){
                count += array.get(nums.get(left)) * array.get(nums.get(right));
                left++;
                right--;
            }
            else if(sum > k){
                right--;
            }
            else{
                left++;
            }
        }
        if(left == right && right < nums.size() && left < nums.size() && right>=0&&left >=0){
            int sum = nums.get(left) + nums.get(right);//left == right
            if (sum == k){
                //do combination C(2, n)
                //pick 2
                //form array.get(nums[left])
                int n = array.get(nums.get(left));
                int C = 0;
                if (n == 1){
                    //do nothing
                    C = 0;
                }
                else{//n > 1
                    int A = 1;
                    for(int j = n, i = 0;i < 2;i++,j--){
                        A = A * j;
                    }
                    C = A / 2;
                    count += C;
                }
            }
        }
        
        
        return count;
    }