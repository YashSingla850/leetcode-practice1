class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length+2];
        for(int d[]:dp)Arrays.fill(d,-1);
    return helper( nums ,0 , -1,dp);
    }
    public int helper(int[]nums , int idx  , int prev,int dp[][]){
        int len  = 0;
        if(idx==nums.length)return 0;
        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
        len = 0+helper(nums , idx+1,prev,dp);
        if(prev==-1 || nums[idx]>nums[prev]){
            len = Math.max(len , 1+ helper(nums , idx+1 , idx,dp));
        }
        return dp[idx][prev+1] = len;
    }
}