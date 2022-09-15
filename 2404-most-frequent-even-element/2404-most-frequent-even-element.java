class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums){
            if(num%2==0){
            map.put(num , map.getOrDefault(num,0)+1);
            }
        }
        int val = (int)1e9;
        int fq = 0;
        for(int key:map.keySet()){
            int freq  = map.get(key);
        
                if(freq>fq){
                    val = key;
                    fq  = freq;
                }else if(freq==fq){
                    val = Math.min(val,key);
                }
            }
        
        if(val==(int)1e9){
            return -1;
        }
        return val;
    }
}