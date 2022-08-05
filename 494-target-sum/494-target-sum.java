class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum  =0;
        for(int s:nums) sum+=s;
         int t1 = sum-target;
        if(t1<0)return 0;
        if(t1%2==1)return 0;
        int s  = t1/2;
        int dp[][]=  new int[n][s+1];
        for(int[]d:dp)Arrays.fill(d,-1);
        return helper(n-1 , s, nums , dp); 
    }
    public int helper(int n , int target , int[] nums ,int dp[][]){
        if(n==0){
            if(target==0&&nums[0]==0){
                return 2;
            }
            if(target==0||target==nums[0]){
                return 1;
            }
            return 0;
        }
        int ntake = helper(n-1  , target , nums , dp);
        int take =0;
        if(nums[n]<=target){
            take = helper(n-1 , target-nums[n],nums, dp);
        }
        return dp[n][target] = take+ntake;
    }
}
