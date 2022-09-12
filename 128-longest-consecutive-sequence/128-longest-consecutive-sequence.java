class Solution {
    public int longestConsecutive(int[] nums) {
        
           if(nums == null || nums.length == 0) return 0;
    Set<Integer> set = new HashSet<>();
    for(int i : nums) set.add(i);
    
    int ans = 0;
    
    for(int num : nums) {
        if(!set.contains(num-1)){
       
        int cur = num;
        int curadd = 0;
        while(set.contains(cur++)) curadd++;
            ans = Math.max(ans,curadd);
        }
    }
    return ans;
    }
}





//  67 test case passed than got TLE

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer>set=new HashSet<>();
//         int max = 0;
//         int min = (int)1e9;
//         for(int i =0 ; i<nums.length;i++){
//             set.add(nums[i]);
//             max = Math.max(max , nums[i]);
//             min  = Math.min(min ,nums[i]);
//         }
//         int ans = 0; 
//         int count =0;
//         for(int i  =min ; i<=max ;i++){
//             if(set.contains(i)){
//                 count++;
//                 ans = Math.max(ans , count);
//             }else{
//                 count = 0;
//             }
//         }
//         return ans;
//     }
// }