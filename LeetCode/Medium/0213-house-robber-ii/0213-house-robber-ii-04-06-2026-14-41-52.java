class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];

        int case1 = solve(0, n - 2, nums, dp1);
        int case2 = solve(1, n - 1, nums, dp2);
        return Math.max(case1, case2);
    }

    public int solve(int start, int end, int[] nums, int[] dp) {
        int len = end - start + 1;
        dp[0] = 0;
        dp[1] = nums[start];

        for (int i = 2; i <= len; i++) {
            int take = nums[start + i - 1] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }

        return dp[len];
    }
}