class Solution {
    public int deleteAndEarn(int[] nums) {
        // Arrays.sort()
        int max =0;
        for(int i =0 ;i<nums.length;i++){
           if(nums[i]>max){
               max = nums[i];
           }
        }
        int [] arr = new int[max+1];
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr , arr.length-1,dp);
    }
    public int helper(int []arr , int n ,int[]dp ){
        if(n<0)return 0;
        if(n<=1)return arr[n]*n;
        if(dp[n]!=-1)return dp[n];
        // int max =0;
        int ntake = helper(arr , n-1,dp);
        int take = arr[n]*n + helper(arr , n-2,dp);
        return  dp [n]  = Math.max(take , ntake);
    }
}



// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         Arrays.sort(nums);
//         return helper(nums , 0 );
//     }
//     public int helper(int []nums , int n){
//         if(n>=nums.length)return 0;
//         int elem   = nums[n];
//         int sum = 0;
//         while(n<nums.length && nums[n]==elem){
//             sum+=elem;
//             n++;
//         }
//         while(n<nums.length && nums[n]==elem+1){
//             n++;
//         }
//         int ans = 0;
//         int ntake = helper(nums , n+1);
//         int take = sum+helper(nums ,n+1);
//         return ans = Math.max(ntake , take);
//     }
// }


// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int n  = nums.length;
//         HashMap<Integer,Integer>map = new HashMap<>();
//         for(int i: nums)map.put(i ,map.getOrDefault(i , 0)+1);
//        return helper(nums , 0,map);
//     }
//     public int helper(int []nums , int n,HashMap<Integer,Integer>map){
//         HashMap<Integer,Integer>map1 = new HashMap<>();
//         int max = -(int)1e9;
//         if(n== nums.length){
//             return 0;
//         }
//         int ntake = helper(nums,n+1 , map);
//         int take = 0;
//         if(map1.containsKey(nums[n]+1)==false && map1.containsKey(nums[n]-1)==false){
//             take = nums[n]*map.get(nums[n])+helper(nums, n+1 , map);
//             map1.put(nums[n],map1.getOrDefault(nums[n],0)+1);
//             map.remove(nums[n]);
//      }
//         max  = Math.max(max , Math.max(take ,ntake));
//         return max;
// }
// }