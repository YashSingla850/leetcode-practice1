class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        
        for(int i = 0; i < words.length; i++){
            //creating a frequency map of the characters 
            int [] strMap = mapStr(words[i]);
            for(int j = 0; j < words.length; j++){
                //Checking if the strings have any common values;
                boolean common = checkStr(words[j], strMap);
                if(!common){
                    int tempProduct = words[i].length() * words[j].length();
                    
                    if(tempProduct > max){
                       max = tempProduct;
                    }
                }
            }
        }
        return max;
    }
    
    //This frequecy map is created using an array of length 26 instead of using a tradtional Hashmap or Hashset
    public int [] mapStr(String word){
        int [] array = new int [26];
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            array[c - 'a']++;
        }
        return array;
    }
    
    //This function checks if the two words have any values in common, returns true if they do and false if they don't
    public boolean checkStr(String word, int [] strMap){
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(strMap[c-'a'] >=1 ){
                return true;
            }
        }
        return false;
    }
}

// ALL TEST CASE PASSED BUT GOT TLE

// class Solution {
//     public int maxProduct(String[] words) {
//         HashMap<Integer,HashSet<Character>>map= new HashMap<>();
//         for(int i = 0; i<words.length;i++){
//              helper(i , map,words);
//         }
//         int max =0;
//          for(int i =0 ; i<words.length ; i++){
//              for(int j = i+1 ; j<words.length;j++){
//                  boolean temp = helper2(i , j , words,map);
//                  if(temp==true){
//                      int n1 = words[i].length();
//                      int n2 = words[j].length();
//                      int ans = n1*n2;
//                      max  = Math.max(max , ans);
//                  }
//              }
//          }
//         return max;
//     }
//     public void helper(int i  , HashMap<Integer,HashSet<Character>>map , String[]words){
//         String s = words[i];
//         for(int j = 0 ;j<s.length();j++){
//             char ch = s.charAt(j);
//              if(map.containsKey(i)==false){
//                  map.put(i , new HashSet<>());
//              }
//             map.get(i).add(ch);
//         }
//     }
//     public boolean helper2(int i , int j , String[]words,HashMap<Integer,HashSet<Character>>map){
//         String s = words[i];
//         HashSet<Character>set = map.get(j);
//           for(int k = 0 ;k<s.length();k++){
//              char ch = s.charAt(k);
//               if(set.contains(ch)==true){
//                   return false;
//               }
//           }
//         return true;
//     }
    
// }