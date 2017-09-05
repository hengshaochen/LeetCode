public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     class Pair {
         int index;
         int sum;
         public Pair(int s, int i) {
             sum = s;
             index = i;
         }
     }
    public int[] subarraySumClosest(int[] nums) {
        int[] answer = new int[2];
        answer[0] = answer[1] = 0;
        
        Pair[] prefix = new Pair[nums.length + 1];
        prefix[0] = new Pair(0, 0);
        
        int sum = 0;
        
        // 求prefix --> O(n)
        for(int i = 0; i < nums.length; i++) {
            //System.out.println(i);
            sum = sum + nums[i];
            prefix[i + 1] = new Pair(sum, i + 1);
        }
        
        // 排序prefix --> O(nlogn)
        // ***為何這樣可以把pair進行sort?
        Arrays.sort(prefix, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        
        // 將兩倆相鄰的prefix相減取絕對值, 取最靠近0的return --> O(n)
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < prefix.length - 1; i++) {
            int neighborSub = Math.abs(prefix[i + 1].sum - prefix[i].sum);
            if (min > neighborSub) {
                min = neighborSub;
                
                int[] temp = new int[]{prefix[i + 1].index, prefix[i].index};
                Arrays.sort(temp);
                answer[0] = temp[0];
                answer[1] = temp[1] - 1;
                // ***為何answer應該是[1,3], 但最後卻return [0,2]
                System.out.println(answer[0]);
                System.out.println(answer[1]);
            }
        }
        return answer;
    }
    
    private void printSum(Pair[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].sum + " ");
        }
        System.out.println("");
    }
    private void printIndex(Pair[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].index + " ");
        }
        System.out.println("");
    }
}
