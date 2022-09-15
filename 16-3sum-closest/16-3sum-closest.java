class Solution {
    public int threeSumClosest(int[] nums, int target) {
       int ans  = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for(int i =0; i<nums.length-2;i++){
            int low = i+1;
             int high = nums.length-1;
            while(low<high){
                int cur_sum = nums[i]+nums[low]+nums[high];
                if(cur_sum>target){
                    high--;
                }else{
                    low++;
                }
                if(Math.abs(cur_sum-target)<Math.abs(ans-target)){
                    ans = cur_sum;
                }
            }
        }
        return ans;
        
    }
}