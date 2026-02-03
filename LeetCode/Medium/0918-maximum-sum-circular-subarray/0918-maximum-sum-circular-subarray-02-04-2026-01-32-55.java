class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max_sum = nums[0];
        int min_sum = nums[0];
        int best = nums[0];

        // Max Sum
        for (int i = 1; i < n; i++) {
            best = Math.max(nums[i], best + nums[i]);
            max_sum = Math.max(best, max_sum);
        }

        // Min Sum
        best = nums[0];
        for (int i = 1; i < n; i++) {
            best = Math.min(nums[i], best + nums[i]);
            min_sum = Math.min(best, min_sum);
        }

        // Total Sum of array
        int total_sum = 0;
        for (int i : nums) {
            total_sum += i;
        }

        // when all numbers are negative in array
        if (min_sum == total_sum) {
            return max_sum;
        }

        return Math.max(max_sum, (total_sum - min_sum));
    }
}