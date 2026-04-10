class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        Integer[][] dp = new Integer[n][n];
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(0, j, grid, dp));
        }
        return ans;
    }

    public int solve(int row, int col, int[][] grid, Integer[][] dp) {
        int n = grid.length;

        if (row == n - 1) return grid[row][col];

        if (dp[row][col] != null) return dp[row][col];

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            if (j != col) {
                min = Math.min(min, solve(row + 1, j, grid, dp));
            }
        }

        return dp[row][col] = grid[row][col] + min;
    }
}