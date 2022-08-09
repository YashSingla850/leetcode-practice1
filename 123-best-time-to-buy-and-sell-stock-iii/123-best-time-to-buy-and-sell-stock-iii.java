class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int dp[][][]= new int[n+1][2][3];
        for(int d[][]:dp){
            for(int di[]:d){
                Arrays.fill(di,-1);
            }
        }
        return helper(prices , 0 , 1 , 2,dp);
        
    }
    public int helper(int []prices , int idx , int buy , int tr,int[][][]dp){
        int profit= Integer.MIN_VALUE;
        if(tr==0)return 0;
        if(idx==prices.length) return 0;
        if(dp[idx][buy][tr]!=-1)return dp[idx][buy][tr];
        if(buy==1){
            profit  = Math.max(-prices[idx]+helper(prices , idx+1 , 0 , tr,dp) ,helper(prices , idx+1 , 1 , tr,dp) );
        }else{
            profit  = Math.max( prices[idx]+helper(prices , idx+1 , 1 , tr-1,dp) ,helper(prices , idx+1 , 0 , tr,dp) );
        }
        return dp[idx][buy][tr] =  profit;
    }
}