class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] prepro = new int[n];
        int[] suffpro = new int[n];

        prepro[0] = 1;

        for(int i=1;i<n;i++){
            prepro[i] = prepro[i-1] * nums[i-1];
        }

        suffpro[n-1] = 1;

        for(int i=n-2;i>=0;i--){
            suffpro[i] = suffpro[i+1] * nums[i+1];
        }

        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = prepro[i] * suffpro[i];
        }

        return ans;
    }
}