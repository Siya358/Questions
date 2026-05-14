class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                ans.add(nums[i]);
            } 
            else {
                int idx = lowBound(ans, nums[i]);
                ans.set(idx, nums[i]);
            }
        }
        return ans.size();
    }

    public int lowBound(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high- low) / 2;
            if (arr.get(mid) >= target) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}