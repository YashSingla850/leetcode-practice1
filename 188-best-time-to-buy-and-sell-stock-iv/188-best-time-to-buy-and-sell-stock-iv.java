class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length+1][2][k+1];
       return  helper(prices , dp , k,1 ,0);
    }
    public int helper(int[]arr , int[][][]dp , int k , int buy , int idx){
        if(k==0)return 0;
        if(idx==arr.length)return 0;
        if(dp[idx][buy][k]!=0)return dp[idx][buy][k];
        int profit = 0;
        if(buy==1){
            profit = Math.max(-arr[idx]+helper(arr , dp , k , 0 , idx+1) , helper(arr , dp , k ,1 , idx+1));
        }else{
            profit = Math.max(arr[idx]+helper(arr , dp , k-1 , 1 , idx+1) , helper(arr , dp , k , 0 , idx+1));
        }
        return dp[idx][buy][k] = profit;
    }
}

// class Solution {
//     public int maxProfit(int k, int[] prices) {
//           int n= prices.length;
//         int dp[][][]= new int[n+1][2][k+1];
//           for(int idx = n-1 ;idx>=0 ;idx--){
//               for(int buy =0;buy<=1 ;buy++){
//                   for(int cap =1 ;cap<=k;cap++){
//                       if(buy==1){
//                           dp[idx][buy][cap] = Math.max(-prices[idx] +dp[idx+1][0][cap] , dp[idx+1][1][cap]);
//                       }else{
//                           dp[idx][buy][cap] = Math.max(prices[idx]+dp[idx+1][1][cap-1] , dp[idx+1][0][cap]);
//                       }
//                   }
//               }
//           }
//         return dp[0][1][k];
//     }
// }