class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][]  = new int[n+1][2];
         int profit = Integer.MIN_VALUE;
          for(int idx =n-1 ; idx>=0;idx--){
              for(int buy = 0;buy<=1;buy++){
             if(buy==1){
                profit  = Math.max(-prices[idx]-fee+dp[idx+1][0],dp[idx+1][1]);
            }else{
                profit  = Math.max(prices[idx] +dp[idx+1][1],dp[idx+1][0]);
            }
               dp[idx][buy] = profit;
              }
          }
        return dp[0][1];
    }
    
}

// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int dp[][]  = new int[n+1][2];
//         for(int[]d:dp)Arrays.fill(d,-1);
//        return helper(0 , 1 , prices , fee ,dp);
//     }
//     public int helper(int idx , int buy , int[]prices , int fee , int [][]dp){
//         int profit = Integer.MIN_VALUE;
//         if(idx==prices.length)return 0;
//         if(dp[idx][buy]!=-1)return dp[idx][buy];
//         if(buy==1){
//             profit  = Math.max(-prices[idx]-fee+helper(idx+1,0 , prices , fee , dp), helper(idx+1 , 1 , prices , fee ,dp));
//         }else{
//             profit  = Math.max(prices[idx] +helper(idx+1,1 , prices , fee , dp), helper(idx+1 , 0 , prices , fee ,dp));
//         }
//         return dp[idx][buy] = profit;
//     }
// }