class Solution {
    public int mergeStones(int[] stones, int K) {
        final int LEN = stones.length;
        int[][] dp = new int[LEN + 1][LEN + 1];
        int[] prefixSum = new int[LEN + 1];
        if ((LEN - 1) % (K - 1) != 0) {
            return -1;
        }
        for (int index = 0; index < LEN; index++) {
            prefixSum[index + 1] = prefixSum[index] + stones[index];
        } 
        for (int k = K; k <= LEN; k++) { 
           
            for (int i = 0; i <= LEN - k; i++) { 
                int j = i + k -1; 
              
                dp[i][j] = Integer.MAX_VALUE;
          
                for (int m = i; m < j; m += K - 1) {
               
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += prefixSum[j + 1] - prefixSum[i];
                }
            }
        }
        return dp[0][LEN - 1];
    }
}