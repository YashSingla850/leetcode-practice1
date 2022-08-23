class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>>map = new HashMap<>();
        for(int i = 0 ; i<stones.length ;i++){
            map.put(stones[i] , new HashSet<>());
        }
        map.get(stones[0]).add(1);
        
        for(int i= 0 ;i<stones.length ;i++){
            int curStone = stones[i];
            HashSet<Integer>jumps = map.get(curStone);
            for(int jump: jumps){
                int pos = curStone+jump;
                    if(pos  == stones[stones.length-1]){
                        return true;
                    }
                if(map.containsKey(pos)==true){
                    if(jump-1>0){
                        map.get(pos).add(jump-1);
                    }
                    map.get(pos).add(jump);
                    map.get(pos).add(jump+1);
                }
            }
            
        }
        return false;
    }
}
// class Solution {
//     public boolean canCross(int[] stones) {
//         HashMap<Integer,Integer>map  = new HashMap<>();
//     if(stones[1]!=1){
//         return false;
//     }
//         for(int i:stones){
//            map.put(i,1);
//         }
//         return helper(stones , 1 ,map);
        
//     }
//     public boolean helper(int []nums , int n , HashMap<Integer,Integer>map ){
//         int len  = nums.length-1;
//        if(n==nums[len]){
//            return true;
//        }
//         else if(n> nums[len]){
//             return false;
//         }
//         int a =  n+1;
//         int b = n;
//         int c  = n-1;
//         boolean val1 = false;
//          if(a>0 && map.containsKey(a)==true){
//              val1 = helper(nums , a ,map);
//          }
//         boolean val2 = false;
//         if(map.containsKey(b)==true){
//             val2= helper(nums , b , map);
//         }
//         boolean val3 = false;
//         if(map.containsKey(c)==true){
//             val3 =  helper(nums , c , map);
//         }
//         return val1 || val2 || val3;
//     }
// }