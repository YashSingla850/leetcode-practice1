class Solution {
    public int longestPalindromeSubseq(String s) {
            StringBuilder sb=new StringBuilder(s);  
              sb.reverse();  
             String t = sb.toString();  
             int  n = s.length();
               int m = t.length();
          int dp [][] = new int[n+1][n+1];
       return helper(n , m , s , t, dp);
    }
    public int helper(int n  , int m , String s ,String t , int[][]dp){
        for(int i =0;i<=n ;i++){
            for(int j =0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                if(i>0 && j>0){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]  = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j]  = Math.max(dp[i-1][j],  dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}