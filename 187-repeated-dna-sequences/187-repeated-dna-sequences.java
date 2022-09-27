class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i= 0 ; i<=s.length()-10 ; i++){
            String temp = s.substring(i, i+10);
            if(set.contains(temp)){
                if(ans.contains(temp)==false){
                ans.add(temp);
                }
            }
            set.add(temp);
        }
        return ans;
    }
}