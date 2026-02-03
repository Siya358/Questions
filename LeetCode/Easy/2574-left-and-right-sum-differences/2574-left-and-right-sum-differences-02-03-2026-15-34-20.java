class Solution {

    public int[] leftRightDifference(int[] nums) {
        
        int sum =0;
       
        for(int num : nums){
            sum += num;

        }
        int leftSum = 0;
        int rightSum =0;
        int ans[] = new int[nums.length];
        for (int i =0; i< nums.length; i++){
            sum -= nums[i];
            ans[i] = Math.abs(leftSum- sum);
            leftSum += nums[i];
            
        }
        return ans;

    }
}