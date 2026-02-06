/*class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int count =0;
        int windowStart = 0;
        int windowEnd =0;
        int product = 1;

        while(windowEnd< nums.length){
            product *=  nums[windowEnd];
            while( product>=k){
                product /= nums[windowStart];
                windowStart++;


            }
            count += windowEnd- windowStart++;
            windowEnd ++;


            

        }
        return count;

        
        
    }
}*/


class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int j=0;
        int prod=1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
            while(j <= i && prod>=k){
                prod=prod/nums[j];
                j++;
            }
            count+=1+ (i - j);
            }
            return count;
        }
    }
