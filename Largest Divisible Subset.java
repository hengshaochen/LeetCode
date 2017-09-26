public class Solution {
    /*
    dp数组表示从0~i包括第i个元素最大的divisible subset size 
    pre数组用来标记 状态转移过程中的方向，用于回溯最大值时的解集。 
    dp[i]=max{dp[i],dp[j]+1}
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        
        int[] f = new int[nums.length];
        int[] pre = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) { //初始化
            f[i] = 1;
            pre[i] = -1;
        }
        
        // f[i]為最大的subset size
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果新來的數字都可以整除前面所有數字 --> 加入
                if (f[i] < f[j] + 1 && nums[i] % nums[j] == 0) {
                    f[i] = f[j] + 1;
                    pre[i] =  j;
                }
            }
        }
        
        int maxIdx = -1, max = -1;
        for (int i = 0; i < nums.length; i++) {//找到最大的子集size 和它最后元素的下标
            if (f[i] > max) {
                max = f[i];
                maxIdx = i;
            }
        }

        // 將答案序列放到ans
        int idx = maxIdx;
        while (idx >= 0) {
            ans.add(nums[idx]);
            idx = pre[idx];
        }
        
        return ans;
    }
}