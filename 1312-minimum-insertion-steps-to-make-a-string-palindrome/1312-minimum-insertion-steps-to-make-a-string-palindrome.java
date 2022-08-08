class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String t = sb.toString();
        int n = s.length();
        int m  = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int d[]:dp)Arrays.fill(d,-1);
        int temp =  helper(n , m , s , t, dp);
            return n-temp;
    }
    public int helper(int n , int m , String s , String t , int[][]dp){
        if(n==0 || m==0){
            return dp[n][m] =0;
        }
        if(dp[n][m]!=-1)return dp[n][m];
       
            if(s.charAt(n-1)==t.charAt(m-1)){
                return dp[n][m] = 1+ helper(n-1 , m-1 , s, t, dp);
            }else{
                return dp[n][m]  = Math.max(helper(n-1 , m , s, t, dp) , helper(n ,m-1 , s, t, dp));
            }

    }
}