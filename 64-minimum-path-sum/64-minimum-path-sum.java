class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[][]dp = new int[n+1][m+1];
        for(int []d:dp)Arrays.fill(d , -1);
        int[][]dir = {{-1,0},{0,-1}};
        return helper(grid , dp  , n-1 , m-1);
    }
    public int helper(int[][]grid , int[][]dp , int n ,int m){
        if(n==0&&m==0){
            return dp[n][m] = grid[n][m];
        }
         if(n<0 || m<0 || n>=grid.length || m>=grid[0].length){
             return (int)1e9;
         }
        if(dp[n][m]!=-1)return dp[n][m];
        
        
        int min = Integer.MAX_VALUE;
        int a = helper(grid , dp , n-1,m);
        int b = helper(grid , dp , n , m-1);
           min = Math.min(min , Math.min(a,b));
    return dp[n][m]=min+grid[n][m];
    }
  
}