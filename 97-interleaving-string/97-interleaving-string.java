class Solution {
    private boolean findInAll
        (String a, String b, int i, int j, String crt, String res,int[][] dp){
    
        if(i==a.length() && j==b.length() && crt.equals(res))return true;
        if(dp[i][j]!=0)return dp[i][j]==1;
        boolean ans = false;
        //pick String a
        if(i<a.length() && res.charAt(i+j)==a.charAt(i))
            ans = ans || findInAll(a,b,i+1,j,crt+a.charAt(i),res,dp);
        //pick String b
        if(j<b.length() && res.charAt(i+j)==b.charAt(j))
            ans = ans || findInAll(a,b,i,j+1,crt+b.charAt(j),res,dp);
       dp[i][j] = ans?1:2;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        //Recursive Approach + memoization
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        int[][] dp = new int[n+1][m+1];
        
        if(n+m != k)return false;
        return findInAll(s1,s2,0,0,"",s3,dp);
    }
}


// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
        
//        if(s1.length()+s2.length()!= s3.length()){
//            return false;
//        }
//         boolean dp[][][] =  new boolean[s1.length()][s2.length()][s3.length()];
//             return helper(0 , 0 , 0 , s1 , s2 ,s3 , dp);
//     }
//     public boolean helper(int i  , int j  , int k , String s1, String s2 , String s3 ,boolean dp[][][]){
//          int n1 =s1.length();
//         int n2 = s2.length();
//         int n3 = s3.length();
      
//         if(i==n1-1 && j ==n2-1 && k==n3-1){
//             return true;
//         } 
//         if(dp[i][j][k] !=null)return dp[i][j][k];       
//         if(i<n1 && s1.charAt(i)==s3.charAt(k)){
//             return dp[i][j][k]= helper(i+1 , j , k+1 ,s1 , s2, s3);
//         }else if(j<n2&& s2.charAt(j)==s3.charAt(k)){
//            return dp[i][j][k]= helper(i , j+1 , k+1 ,s1 , s2, s3);
//         }else if(i<n1 && j<n2 && k<n3 && s1.charAt(i)==s3.charAt(k) && s2.charAt(j)==s3.charAt(k)){
//             return dp[i][j][k]= helper(i+1 , j , k+1 ,s1 , s2, s3)||  helper(i , j+1 , k+1 ,s1 , s2, s3);
//         }
    
//         return dp[i][j][k]= false;
//     }
// }