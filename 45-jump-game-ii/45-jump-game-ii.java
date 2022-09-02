class Solution {
    public int jump(int[] nums) {
        int n   = nums.length;
        int[]dp = new int[n+1];
          Arrays.fill(dp,-1);
         return helper(0 , nums , dp);
    }
    public int helper(int n , int[]nums , int[]dp){
        // int val = nums[0];
        if(n==nums.length-1)return 0;
        if(n>nums.length){
            return Integer.MAX_VALUE;
        }
        if(dp[n]!=-1)return dp[n];
        int min = (int)1e9;
        for(int i  =1 ; i<=nums[n];i++){
            if(n+i<nums.length){
         min = Math.min(min , 1+helper(n+i , nums, dp));
            }
        }
        return dp[n] = min;
    
    }
}