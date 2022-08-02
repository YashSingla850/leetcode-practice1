class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[][]dp = new int[n+1][m+1];
        for(int []d:dp)Arrays.fill(d , -1);
        int[][]dir = {{-1,0},{0,-1}};
        return helper(grid , dp  ,dir,  n-1 , m-1);
    }
    public int helper(int[][]grid , int[][]dp ,int[][]dir ,int n ,int m){
        if(n==0&&m==0){
            return dp[n][m] = grid[n][m];
        }
         if(dp[n][m]!=-1)return dp[n][m];
              int min = Integer.MAX_VALUE;
           for(int d =0;d<dir.length;d++){
               int r = n+dir[d][0];
               int c = m+dir[d][1];
               if(r>=0 && c>=0 && r<grid.length && c< grid[0].length){
                   min = Math.min(min,helper(grid , dp , dir, r, c));
               }
           }
            return dp[n][m]  = min+grid[n][m];
    }
  
}