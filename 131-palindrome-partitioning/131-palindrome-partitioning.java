class Solution {
    List<List<String>>ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0 , new ArrayList<>());
        return ans;
    }
    public void dfs(String s , int start  , List<String>list){
        if(start == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start ; i<s.length();i++){
            if(isPallindrome(s , start , i)){
                list.add(s.substring(start , i+1));
                dfs(s,i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPallindrome(String s , int start , int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++ ;
            end--;
            
        }
        return true;
    }
}