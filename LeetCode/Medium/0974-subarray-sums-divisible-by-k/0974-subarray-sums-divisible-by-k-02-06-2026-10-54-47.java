class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int ans = 0;
        
        int sum =0;
        
        HashMap<Integer, Integer> mp= new HashMap<>();
        mp.put(0,1);

        for (int i=0; i<nums.length; i++){
            sum+= nums[i];
            int divisor =sum% k;
            if(divisor <0){
                divisor +=k; // if remainder is -ve, add k
            }
            if(mp.containsKey(divisor)){
                ans += mp.get(divisor);
                mp.put(divisor,mp.get(divisor)+1);
                
            }else{
                mp.put(divisor,1);
            }

        }
        return ans;

        
    }
}
