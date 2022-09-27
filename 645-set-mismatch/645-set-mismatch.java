class Solution {
    public int[] findErrorNums(int[] nums) {
     HashMap<Integer,Integer>map = new HashMap<>();
        int max = 0 ;

        for(int i =0 ; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            max = Math.max(max ,nums[i]);
          
        }
        int ans [] = new int[2];
        for(int i = 1; i<=max ;i++){
             if(map.containsKey(i)==true){
                 int freq = map.get(i);
                 if(freq==2){
                     ans[0] = i;
                 }
             }else{
                 ans[1] = i;
             }
        }
        if(ans[1]==0){
            ans[1] = max+1;
        }
        return ans;
    }
}