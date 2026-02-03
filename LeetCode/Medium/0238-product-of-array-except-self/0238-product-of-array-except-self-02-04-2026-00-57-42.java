class Solution {
    public int[] productExceptSelf(int[] nums) {

        int zeroCount = 0;
        int totalProduct = 1;

        // count zero + product
        for(int i=0; i<nums.length; i++){

            int num = nums[i];

            if(num == 0){
                zeroCount++;
            }else{
                totalProduct *= num;
            }
        }

        int[] ans = new int[nums.length];

        for(int i=0;i<nums.length;i++){

            if(zeroCount > 1){
                ans[i] = 0;
            }
            else if(zeroCount == 1){
                if(nums[i] == 0){
                    ans[i] = totalProduct;
                }else{
                    ans[i] = 0;
                }
            }
            else{
                ans[i] = totalProduct / nums[i];
            }
        }

        return ans;
    }
}