public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        Arrays.sort(S);
        int count = 0;
        for (int i = 2; i < S.length; i++) {
            int left = 0;
            int right = i - 1; // right一定是i的左邊一個
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    count = count + (right - left);
                    right--;
                } else if (S[left] + S[right] <= S[i]) {
                    left++;
                }
            }
        }
        return count;
    }
}
