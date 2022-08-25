class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) ->  (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));

        int[] heights = new int[envelopes.length];
        for(int i = 0; i < heights.length; i++){
            heights[i] = envelopes[i][1];
        }

        return getLIS(heights);
    }
    
    private int getLIS(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        
        for(int num : nums){
            int index = Arrays.binarySearch(dp, 0, len, num);
            
            if(index < 0){
                index = -(index + 1);
            }
            
            dp[index] = num;
            
            if(index == len)
                len++;
        }
        
        return len;
    }
}

// my solution TLE (83 TEST CASE PASSED)
// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         int n = envelopes.length;
//         Arrays.sort(envelopes , (a,b)->{
//             return a[0]-b[0];
//         });
//         int []arr = new int [n];
//             for(int i = 0;i<n;i++){
//                 arr[i] = envelopes[i][1];
//             }
//         int dp [][] = new int [n][n];
//         for(int d[]:dp)Arrays.fill(d, -1);
//         return helper(0 , -1  , envelopes, dp);
//     }
//     int helper(int idx ,int prev ,int [][]arr , int [][]dp){
//         int len =0;
//         if(idx==arr.length)return 0;
//         if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
// //         ntake;
//         len = helper(idx+1 , prev , arr, dp);
// //         take;
//         if(prev== -1 || arr[idx][0]>arr[prev][0]&&arr[idx][1]>arr[prev][1]){
//             len = Math.max(len , 1+helper(idx+1 , idx , arr , dp));
//         }
//         return dp[idx][prev+1] = len;
//     }
// }