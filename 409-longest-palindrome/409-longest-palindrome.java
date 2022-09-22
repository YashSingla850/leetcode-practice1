class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i =0 ; i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        int count =0 ; 
        // int max = 0;
        boolean flag = false;
        for(char key:map.keySet()){
            int freq = map.get(key);
            if(freq%2!=0){
              count+=freq-1;
                flag= true;
            }else{
                count+=freq;
            }
            
        }
        if(flag==true)count++;
        return count;
    }
}