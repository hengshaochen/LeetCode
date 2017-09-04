
// Version 2: Prefix Sum

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            
            /*System.out.println("----");
            System.out.println(i);
            System.out.println("sum:"+sum);
            System.out.println("max:"+max);
            System.out.println("minSum:"+minSum);/*
        }
        return max;
    }
}