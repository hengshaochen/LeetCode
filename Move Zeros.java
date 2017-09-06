public class Solution {
    /*
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        // 雙指標基礎題： i指向0, j指向非0
        // 思路：兩指標, i不斷想辦法指向0, j不斷想辦法指向非0, 如果i指向0, j同時也指向非0, 則swap, 如果超出邊界就不找了
        // **注意： 要保證j要在i後面, 這樣才會把0往後移動, 因此要加上 if (i < j)
        // 還有if(j < i) j = j + 1這兩個條件
        // ex: [-1,2,-3,4,0,1,0,-2,0,0,1], j = 0, i = 4, 如果沒加上上面兩個條件,會直接swap, 這樣0反而會跑到前面
        if (nums == null || nums.length == 0) { return; }
        int i = 0, j = 0;
        
        while (i < nums.length && j < nums.length) {
            if (i < j && nums[i] == 0 && nums[j] != 0) {
                //swap(nums[i], nums[j]);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                // 想辦法讓i指向0, j指向非0
                if (nums[i] != 0) {
                    i = i + 1;
                }
                if (nums[j] == 0 || j < i) {
                    j = j + 1;
                }
            }
        }
    }
    /*
    數值不會改變, 因為java只有pass by value
    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    */
}