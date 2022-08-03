class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [][]dp = new int[n][n];
         // for(int[]d:dp)Arrays.fill(d,-1);    
        int [][]dir = {{1,0},{1,1},{1,-1}};
        int min = (int)1e8;
        for(int j =0;j<n;j++){
       min = Math.min(min,helper(n-1 , j , dp , dir ,matrix));
        }
        return min;
    }
    public int helper(int i , int j , int [][]dp , int [][]dir , int [][]matrix){
        
        if(j<0 || j>=matrix[0].length)return (int)1e8;
        if(i==0)return matrix[0][j];
        if(dp[i][j]!=0)return dp[i][j];
        int a  = matrix[i][j]+helper(i-1 , j , dp , dir ,matrix);
         int b  = matrix[i][j]+helper(i-1 , j-1 , dp , dir ,matrix);
         int c  = matrix[i][j]+helper(i-1 , j+1 , dp , dir ,matrix);
         return dp[i][j] = Math.min(a, Math.min(b,c));
        
    }
}
        // int n = matrix.length;
        // if(i==n-1){
        //     return matrix[n-1][j];
        // }
        // if(dp[i][j]!=-1)return dp[i][j];
        // for(int d =0;d<dir.length;d++){
        //     int min =0;
        //     int r = i+dir[d][0];
        //     int c  = j+dir[d][1];
        //     if(r>=0 && c>=0 && r<matrix.length && c<matrix.length){
        //         min = Math.min(min , helper(r, c, dp , dir , matrix));
        //     }
        //     return dp[r][c]  = min+matrix[i][j];
        // }
        // return dp[i][j];