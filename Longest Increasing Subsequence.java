// Version2: my version
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
   
    
    public int longestIncreasingSubsequence(int[] nums) {
        int[] x = new int[nums.length];
        // x[i] 代表由“某個位置”到達下標i時的LIS
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            x[i] = 1;
            for (int j = 0; j < i; j++) {
                // i是當前, j是i之前的所有數的掃描
                if (nums[j] < nums[i]) {
                    // 如果前面的位置有比當前位置的大, 把前面位置的加上1,
                    // 因為進到這個if代表前面位置的value一定比當前位置value小
                    // 代表可以從前面位置跳到i這個位置
                    if (x[j] >= x[i]) {
                        x[i] = x[j] + 1;
                    }
                }
            }
            if (max < x[i]) {
                max = x[i];
            }
        }
        return max;
    }
}

// Version1
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
   
    
    public int longestIncreasingSubsequence(int[] nums) {
        int []f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
                System.out.println("i:" + i + " j:" + j);
                System.out.println("f[i]" + f[i]);
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}

// Version3: O(nlogn) DP + Binary Search
// O(nlogn) Binary Search
public class Solution {
    public int longestIncreasingSubsequence(int[] nums) {
        int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // minLast[i]為長度為i的LIS, 其結尾最小的數值
            // ex: 4,2,4,5,3,7 , minLast[4]為長度為4的LIS, 結尾最小數字必須是7, 因為只有這個可能：2,4,5,7
            // find the first number in minLast >= nums[i]
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
            /*
            System.out.println(index);
            for (int j = 0; j < nums.length; j++) {
                System.out.println(minLast[j]);
            }
            System.out.println();
            */
        }
        /*
        for (int i = 0; i < nums.length; i++) {
            System.out.println(minLast[i]);
        }*/
        
        for (int i = nums.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        
        return 0;
    }
    
    // find the first number > num
    private int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return end;
    }
}