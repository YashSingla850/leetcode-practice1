class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n==1)return false;
        
        int sum =0;
        for(int i =0;i<n;i++){
            sum+=nums[i];
        }
        boolean ans = false;
        int target = sum/2;
        boolean [][] dp = new boolean[n][target+1];
        if(sum%2!=0){
            return false;
        }else{
            ans = helper(n-1 , nums , target ,dp);
            if(ans==true){
                return true;
            }
        }
        return false;
    }
    public boolean helper(int I , int []arr,int Target ,boolean [][]dp){
        for(int i =0;i<=I;i++){
                    dp[i][0] = true;
            if(arr[0]<=Target){
                    dp[0][arr[0]]= true;
            }
        }
        for(int i = 1;i<=I;i++){
            for(int target = 1;target<=Target;target++){
             
                boolean ntake = dp[i-1][target];
                boolean take = false;
                if(target>=arr[i]){
                    take = dp[i-1][target-arr[i]];
                }
                dp[i][target] = take|| ntake;
            }
        }
        return dp[I][Target];
    }
}