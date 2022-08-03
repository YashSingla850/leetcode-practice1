class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];
        for(int d[]:dp)Arrays.fill(d,-1);
      return helper(0 , 0 , dp ,triangle, n);
        
    }
    public int helper(int i ,int j ,int[][]dp,List<List<Integer>> triangle,int n  ){
           if(i==n-1){
               return triangle.get(n-1).get(j);
           }
        if(dp[i][j]!=-1)return dp[i][j];
        int d  = triangle.get(i).get(j)+helper(i+1,j ,dp,triangle , n);
        int dg = triangle.get(i).get(j)+helper(i+1,j+1,dp ,triangle , n);
        return dp[i][j] =  Math.min(d, dg);
     }
}