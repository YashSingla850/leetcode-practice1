class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int []d:dp)Arrays.fill(d,-1);
        return helper(prices ,  0 , 1,dp);
    }
    public int helper(int []prices , int ind , int buy,int[][]dp){
        int profit = Integer.MIN_VALUE;
        if(ind==prices.length)
            return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        if(buy==1){
            profit = Math.max(-prices[ind]+helper(prices , ind+1 , 0,dp) , 0+helper(prices , ind+1 , 1,dp));
        }else{
            profit = Math.max(prices[ind]+helper(prices , ind+1 , 1,dp) , 0+helper(prices , ind+1 , 0,dp));
        }
        return dp[ind][buy] = profit;
    }
}