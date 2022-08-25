class Solution {
    public boolean canConstruct(String s1, String s2) {
       HashMap<Character , Integer>map = new HashMap<>();
        for(int i =0;i<s2.length();i++){
            char ch = s2.charAt(i);
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        for(int i = 0; i<s1.length();i++){
            char ch = s1.charAt(i);
            if(map.containsKey(ch)==false){
                return false;
            }else{
                int freq = map.get(ch);
                if(freq==1){
                    map.remove(ch);
                }else{
                map.put(ch , freq-1);
                }
            }
        }
        return true;
    }
}