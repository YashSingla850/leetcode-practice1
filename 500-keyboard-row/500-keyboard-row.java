class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character,Integer>map1 = new HashMap<>();
        HashMap<Character,Integer>map2 = new HashMap<>();
        HashMap<Character,Integer>map3 = new HashMap<>();
        String s1  = "qwertyuiop";
            String s2 = "asdfghjkl";
            String s3 = "zxcvbnm";
          helper(s1,map1);
        helper(s2 , map2);
        helper(s3, map3);
        List<String>  list = new ArrayList<>();
        
        for(int i = 0 ;i<words.length ;i++){
            String temp  =  words[i];
            int c1 =0,c2 =0 , c3 =0;
            for(int j = 0 ; j<temp.length() ;j++){
                char ch = temp.charAt(j);
                if(map1.containsKey(ch)==true){
                    c1++;
                }else if(map2.containsKey(ch)==true){
                    c2++;
                }else if(map3.containsKey(ch)==true){
                    c3++;
                }
            }
            if(c1!=0 && c2==0 &&c3==0){
                list.add(temp);
            }else if(c1==0 && c2!=0 && c3==0){
                list.add(temp);
            }else if(c1==0 && c2==0 &&c3!=0){
                list.add(temp);
            }

        }
            return list.toArray(new String[0]);
    }
    public void helper(String s , HashMap<Character,Integer>map){
        for(int i = 0;i<s.length();i++){
            char ch  =s.charAt(i);
            map.put(ch , 1);
        }
    }
}