class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = 0;  // min要是0, 不能是MAX_VALUE
        
        // 算prefix
        int prefix = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefix = prefix + nums[i];
            // 要先寫max這行再寫min這行
            if (max < prefix - min) {
                max = prefix - min;
            }
            if (min > prefix) {
                min = prefix;
            }
        }
        
        return max;
    }
}

// 
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = 0;
        
        // 如果要index:
        //int start = -1;
        //int end = -1;
        
        // 算prefix
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            if (max < prefix[i + 1] - min) {
                max = prefix[i + 1] - min;
                //end = i;
            }
            if (min > prefix[i + 1]) {
                min = prefix[i + 1];
                //start = i;
            }
        }
        
        // 最後subarray的範圍是start + 1 ~ end
        // ex: 假設原本prefix算出來還沒+1前的start = 2, end = 6. 代表是array[0~2] 和array[0~6]的和
        // 兩者相減就變成array[3~6]的和, 因此真正的範圍是start + 1 ~ end
        //start = start + 1;
        //System.out.println("start, end: " + start + ", " + end);
        return max;
    }
}