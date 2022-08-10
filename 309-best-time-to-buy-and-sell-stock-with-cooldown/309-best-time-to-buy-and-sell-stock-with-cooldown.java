class Solution {
    public int maxProfit(int[] prices) {
        int n  = prices.length;
        int dp [][] = new int [n+1][2];
        for(int[]d:dp)Arrays.fill(d,-1);
       return helper(prices , 1 , 0,dp);
        
    }
    public int helper(int[]prices , int buy , int idx,int[][]dp){
        int profit  = Integer.MIN_VALUE;
        if(idx>=prices.length)return 0;
        if(dp[idx][buy]!=-1)return dp[idx][buy];
        
        if(buy==1){
            
             profit = Math.max(-prices[idx]+helper(prices , 0 , idx+1,dp) , helper(prices , 1 , idx+1,dp));
            
        }else{
             profit = Math.max(prices[idx]+helper(prices , 1 , idx+2,dp) , helper(prices , 0 , idx+1,dp));
        }
        return dp[idx][buy] = profit;
    }
}