class Solution {
    public int nthUglyNumber(int n) {
        int dp[]  = new int [n];
        dp[0] = 1 ; 
        int p1 =0 , p2 = 0 ,p3 =0;
        for(int i = 1 ;i<n ; i++){
            int twoMultiple = dp[p1]*2;
            int threeMultiple = dp[p2]*3;
            int fiveMultiple = dp[p3]*5;
            dp[i] = Math.min(twoMultiple,Math.min(threeMultiple,fiveMultiple));
            if(dp[i]==twoMultiple)p1++;
            if(dp[i]==threeMultiple) p2++;
            if(dp[i]==fiveMultiple) p3++;
        }
        return dp[n-1];
    }
}

//  WRONG ANSWER -:

// class Solution {
//     public int nthUglyNumber(int n) {
//         if(n==1)return 1;
//         int count = 1 ;
//           int i =2 ;
//         while(true){
//           boolean ans =   helper(i);
//             if(ans==true){
//                 count++;
//                 if(n==count){
//                     return i;
//                 }
//             }
//             i++;
//         }
//     }
//         public boolean helper(int n){
//             if(n%2==0){
//                 return true;
//             }else if(n%3==0){
//                 return true;
//             }else if(n%5==0){
//                 return true;
//             }
//             return false;
//     }
// }