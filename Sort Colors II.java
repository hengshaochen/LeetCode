class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // Version1: Counting Sort
        if (colors == null || colors.length == 0) { return; }
        int[] count = new int[k + 1];
        
        // Step1: 統計數量 --> O(n)
        for (int i = 0; i < colors.length; i++) {
            count[colors[i]]++;
        }
        
        // Step2: 利用count array覆蓋原Array --> O(k)
        int idx = 0;
        for (int i = 1; i <= k; i++) {
            while (count[i] != 0) {
                count[i]--;
                colors[idx] = i;
                idx++;
            }
        }
    }
}