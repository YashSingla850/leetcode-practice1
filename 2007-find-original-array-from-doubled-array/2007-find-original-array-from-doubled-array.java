class Solution {
    public int[] findOriginalArray(int[] changed) {
      
      if (changed.length%2 == 1)
        return new int[0];
      
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int a = 0; a < changed.length; a++)
        map.put(changed[a], map.getOrDefault(changed[a], 0) + 1);
      
      int[] result = new int[changed.length/2];
      
      int count = 0;
      
      List<Integer> value = new ArrayList<>(map.keySet()); 
      
      Collections.sort(value); 
      
      for (Integer temp : value) {
        
		// when value is 0 then 2 * 0 = 0, in that case we take count/2
        if (temp == 0) {
          if (map.get(temp)%2 == 1)
            return new int[0];
          int s = map.get(temp) / 2;
          while(s-- > 0)
            result[count++] = 0;
          continue; 
        }
        
		// when smaller value is already considered 
        if (map.get(temp) == 0)
          continue; 
        
        if (map.containsKey(2 * temp)) {
          if (map.get(2 * temp) - map.get(temp) >= 0) {
            int s = map.get(temp);
            while(s-- > 0)
              result[count++] = temp; 
            map.put(2 * temp, map.get(2 * temp) - map.get(temp));
          } else {
            return new int[0]; 
          }
        } else {
          return new int[0]; 
        }
      }
      
      return result; 
      
    }
}


// my solution 120 test case passed out of 170 

// class Solution {
//     public int[] findOriginalArray(int[] changed) {
//         HashMap<Integer,Integer>map = new HashMap<>();

//         int n = changed.length;
      
//        int[]ans  = new int[n/2];
        
//         if(n%2!=0){
//            return ans;
//         }
//          for(int val:changed){
        
//              map.put(val,map.getOrDefault(val,0)+1);    
//          }
        
//                 collections.sort(map);
//         int j =0;
//         for(int key:map.keySet()){
//              if(key==0){
//                  int freq  = map.get(key);
//                  if(freq%2!=0){
//                      return new int[0];
//                  }else{
//                      ans[j] = 0;
//                      map.put(key ,freq-2);
//                     j++;
//                  }
//              }else{
//                  int val = key*2;
//                  if(map.containsKey(val)==true){
//                      int freq = map.get(val);
//                      ans[j] =  key;
//                      j++;
//                      if(freq==1){
//                          map.remove(val);
//                      }else{
//                          map.put(val , freq-1);
//                      }
//                  }
//              }
//         }
//         if(j<n/2){
//             return new int[0];
//         }
//          return ans;
//     }
// }