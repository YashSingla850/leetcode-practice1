class Solution {
    public int countPalindromicSubsequences(String s) {
        int mod = (int)1e9+7;
        int dp[][] = new int[s.length()][s.length()];
        int []prev = new int[s.length()];
        int []next  = new int[s.length()];
        HashMap<Character ,Integer>map = new HashMap <>();
//         prev
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)==false){
                prev[i] =-1;
            }else{
                prev[i] = map.get(ch);
            }
            map.put(ch,i);
        }
//         next
        map.clear();
        for(int i = s.length()-1;i>=0;i--){
        char ch = s.charAt(i);
        if(map.containsKey(ch)==false){
            next[i] =-1;
        }else{
            next[i] = map.get(ch);
        }
        map.put(ch,i);
    }
//         using gap method
        for(int g =0 ; g<s.length();g++){
            for(int i =0 ,j =g ; j<s.length();i++,j++){
                if(g==0){
                    dp[i][j] = 1;
                }else if(g==1){
                    dp[i][j] = 2;
                }else{
                    char sc = s.charAt(i);
                    char ec = s.charAt(j);
                    if(sc!=ec){
                        dp[i][j]  = (dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]);
                    }else{
                        int n = next[i];
                        int p = prev[j];
                        if(n>p){
                            dp[i][j] = (2*dp[i+1][j-1]+2);
                        }else if(n==p){
                            dp[i][j] = (2*dp[i+1][j-1]+1);
                        }else{
                            dp[i][j] = (2*dp[i+1][j-1] - dp[n+1][p-1])%mod;
                        }
                    }
                }
                  dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][s.length()-1]%mod;
    }
}

// WRONG ANSWER -: 

// class Solution {
//     int count =0;
//     public int countPalindromicSubsequences(String s) {
//        HashMap<Character,Integer>map =  new HashMap<>();
//         int max = 0;
//         for(int i = 0;i<s.length();i++){
//             char ch = s.charAt(i);
//              if(map.containsKey(ch)==true){
//                  int freq = map.get(ch);
//                  map.put(ch , freq+1);
//                  if(max<freq+1) max = freq;
//              }else{
//                  map.put(ch,  1);
//              }
//         }
//         int temp =0;
//         for(Character c: map.keySet()){
//             int freq = map.get(c);
//             temp=temp+freq;
//         }
//         StringBuilder sb = new StringBuilder(s);
//         sb.reverse();
//        String s2 =  sb.toString();
//         int n  = s.length();
//         int m = sb.length();
//         int [][]dp = new int[n+1][m+1];
//         for(int []d:dp)Arrays.fill(d,-1);
//         int count =  helper( n , m , s ,s2 ,dp,max);
//         return count+temp;
//     }
//     public int helper(int n  , int m , String s ,String t , int[][]dp , int max){
//         int count =0;
//         for(int i =0;i<=n ;i++){
//             for(int j =0;j<=m;j++){
//                 if(i==0 || j==0){
//                     dp[i][j] = 0;
//                 }
//                 if(i>0 && j>0){
//                     if(s.charAt(i-1)==t.charAt(j-1)){
//                         dp[i][j]  = 1+dp[i-1][j-1];
//                         // if(dp[i][j]>max)count++;
//                     }else{
//                         dp[i][j]  = Math.max(dp[i-1][j],  dp[i][j-1]);
//                         // if(dp[i][j]>max)count++;
//                     }
//                 }
//             }
//         }
//         if(dp[n][m]>max){
//             count = dp[n][m]-max;
//         }
//         return count;
//     }
// }