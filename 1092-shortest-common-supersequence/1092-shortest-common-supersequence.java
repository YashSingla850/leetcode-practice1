class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int[]d:dp)Arrays.fill(d,-1);
        return helper(n , m , str1 , str2 , dp);
        
    }
    public String helper(int n , int m , String s1 , String s2 , int [][]dp){
        for(int i =0;i<=n ;i++){
            for(int j =0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                if(i>0&&j>0){
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        int x= n ,  y = m;
         while(x>0 && y>0){
             if(s1.charAt(x-1)==s2.charAt(y-1)){
                 sb.append(s1.charAt(x-1));
                 x-- ;
                 y--;
                 
             }else if(dp[x-1][y]>dp[x][y-1]){
                 sb.append(s1.charAt(x-1));
                 x--;
             }else{
                 sb.append(s2.charAt(y-1));
                 y--;
             }
         }
        while(x>0){
            sb.append(s1.charAt(x-1));
            x--;
        }
        while(y>0){
            sb.append(s2.charAt(y-1));
            y--;
        }
        sb.reverse();
        return sb.toString();
    }
    
}