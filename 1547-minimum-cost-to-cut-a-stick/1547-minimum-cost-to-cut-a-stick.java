class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int dp[][]= new int[m+1][m+1];
        for(int[]d:dp)Arrays.fill(d,-1);
        List<Integer>list = new ArrayList<>();
        list.add(0);
        for(int i:cuts){
            list.add(i);
        }
        list.add(n);
        Collections.sort(list);
       return helper(1 , cuts.length , list,dp);
    }
    public int helper(int i ,int j , List<Integer>list, int [][]dp){
        if(i>j)return 0;
        int min = (int)1e9;
        if(dp[i][j]!=-1)return dp[i][j];
        for(int idx =i  ;idx<=j ; idx++){
            int cost = list.get(j+1) - list.get(i-1)+helper(i , idx-1 , list,dp)+helper(idx+1 , j ,list,dp);
            min = Math.min(min,cost);
        }
        return dp[i][j] =  min;
    }
}