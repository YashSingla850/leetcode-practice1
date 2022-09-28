class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
   int []dp = new int[n+1];
      Arrays.fill(dp,-1);
       return helper(nums, n-1 , dp);
    }
    public  int helper(int[]arr,  int i , int[]dp){
        if(i==0){
            return arr[i];
        }
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        int ntake = helper(arr, i-1 , dp);
        int take = helper(arr , i-2, dp)+arr[i];
        return dp[i] = Math.max(ntake , take);
    }
}