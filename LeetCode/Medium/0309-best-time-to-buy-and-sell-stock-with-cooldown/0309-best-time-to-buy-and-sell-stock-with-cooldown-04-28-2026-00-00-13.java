class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp = new int[n + 2]; 

        for (int i = n - 1; i >= 0; i--) {
            int max = dp[i + 1];

            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (j + 2 < n) {
                    profit += dp[j + 2]; 
                }
                max = Math.max(max, profit);
            }

            dp[i] = max;
        }

        return dp[0];
    }
}