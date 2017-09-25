// DP + Linear O(n^2) --> TLE
public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if(envelopes == null || envelopes.length == 0 
            || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                // 如果w相等, 要故意把h大的放前面, 因為w和h都必須大, 才能包進去
                // ex: [6,4][6,7] --> [6,7][6,4] , 因為[6,7]不能包[6,4], 但如果sort成[6,4][6,7] 後面用h來查會以為可以包 
                if(arr1[0] == arr2[0]) 
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            } 
        });
        
        // 設f[i]為從某個點到下標為i時, 最多可以包幾個幾個
        int[] f = new int[envelopes.length];
        f[0] = 1;
        int max = 0;
        for (int i = 1; i < envelopes.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                // 找到前面的最優解才更新
                if (envelopes[i][1] > envelopes[j][1] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                }
            }
            if (max < f[i]) {
                max = f[i];
            }
        }
        
        return max;
    }
}

// Version2: DP + Binary Search O(nlogn)
public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if(envelopes == null || envelopes.length == 0 
            || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            } 
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
                if(index < 0)
                    index = -index - 1;
            dp[index] = envelope[1];
            if (index == len)
                len++;
        }
        return len;
    }
}