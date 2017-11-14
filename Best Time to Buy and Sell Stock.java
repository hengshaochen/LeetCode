class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) { return 0; }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(prices[i] - min, profit);
        }
        return profit;
        
        /* O(n) 超時
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] <= max || prices[j] == prices[j - 1]) {
                    continue;
                }
                if (prices[j] > prices[i]) {
                    int cur_profit = prices[j] - prices[i];
                    max = Math.max(max, cur_profit);
                }
            }
        }
        return max;
        */
    }
}