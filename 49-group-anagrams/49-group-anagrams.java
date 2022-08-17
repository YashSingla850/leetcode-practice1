class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer> , List<String>>map = new HashMap<>();
        for(String str : strs){
            HashMap<Character , Integer>map1 = new HashMap<>();
            for(int j = 0  ;j<str.length();j++){
                char ch = str.charAt(j);
                map1.put(ch , map1.getOrDefault(ch , 0)+1);
            }
            if(map.containsKey(map1)==false){
                List<String>list =  new ArrayList<>();
                list.add(str);
                map.put(map1 , list);
            }else{
                List<String> list = map.get(map1);
                list.add(str);
                map.put(map1 , list);
            }
        }
        List<List<String>>list = new ArrayList<>();
        for(List<String>val:map.values()){
            list.add(val);
        }
        return list;
    }
}