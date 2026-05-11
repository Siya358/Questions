class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = minDenominations(0, amount, coins, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int minDenominations(int i,int amount,int[] coins,int[][] dp) {
        if (amount == 0) return 0;
        if (i == coins.length) return Integer.MAX_VALUE;
        if (dp[i][amount] != -1) return dp[i][amount];
        int pick = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            int next = minDenominations(i,amount - coins[i],coins,dp);
            if (next != Integer.MAX_VALUE) {
                pick = 1 + next;
            }
        }
        int skip = minDenominations(i + 1,amount,coins,dp);
        return dp[i][amount] = Math.min(pick, skip);
    }
}