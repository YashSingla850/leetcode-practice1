class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer>list = new ArrayList<>();
        int dp[][] = new int[n+1][n+1];
        for(int[]d:dp)Arrays.fill(d, -1);
        list.add(1);
        for(int i:nums) list.add(i);
        list.add(1);
      return  helper(1 , n , list,dp);
    }
    public int helper(int i , int j , List<Integer>list,int[][]dp){
        if(i>j)return 0;
        int max = -(int)1e9;
        if(dp[i][j]!=-1)return dp[i][j];
        for(int idx  = i ; idx<=j ; idx++){
            int temp = list.get(i-1)*list.get(idx)*list.get(j+1)+helper(i , idx-1 , list,dp)+helper(idx+1 , j  ,list,dp);
            max = Math.max(max , temp);
        }
        return dp[i][j] = max;
    }
}