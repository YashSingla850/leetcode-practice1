class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,ArrayList<Integer>>map= new HashMap<>();
        for(int i = 0; i<nums.length ;i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i] , new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int gpair =0 ;
        for(int key:map.keySet()){
            ArrayList<Integer>list = map.get(key);
            if(list.size()>1){
            for(int i = 0 ;i<list.size();i++){
                for(int j = i+1 ; j<list.size();j++){
                    gpair++;
                }
            }
        }
      }
        return gpair;
    }
}