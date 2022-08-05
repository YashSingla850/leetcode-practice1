class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int dp [][] = new int[n][amount+1];
        for(int d[]:dp)Arrays.fill(d,-1);
       int val =  helper(n-1 , amount , coins , dp);
        if(val==1000000000){
            return -1;
        }
        return val;
    }
    public int helper(int n , int target , int[]coins , int dp[][]){
        if(n==0){
            return dp[n][target] = (target%coins[n]==0)?target/coins[n]:(int)1e9;
        }
        if(dp[n][target]!=-1)return dp[n][target];
        int ntake = helper(n-1  ,target , coins , dp);
        int take = (int)1e9;
        if(coins[n]<=target){
            take = 1+helper(n , target-coins[n] , coins , dp);
        }
        return dp[n][target] = Math.min(ntake , take);
    }
}