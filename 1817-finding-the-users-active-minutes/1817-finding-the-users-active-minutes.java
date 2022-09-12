class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,HashSet<Integer>> map  = new HashMap<>();
        int []arr = new int[k];
        for(int i = 0 ; i<logs.length ;i++){
            int val1 = logs[i][0];
            int val2 = logs[i][1];
             if(map.containsKey(val1)==false){
                 map.put(val1 , new HashSet<Integer>());
             }
            map.get(val1).add(val2);
        }
         for(int key:map.keySet()){
             int freq = map.get(key).size();
             arr[freq-1]++;
         }
        return arr;
    }
}