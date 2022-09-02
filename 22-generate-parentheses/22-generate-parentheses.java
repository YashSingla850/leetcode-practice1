class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        helper("(" , 1, 0 , ans ,n);
        return ans;
    }
 void helper(String cur , int open , int close , List<String>ans , int n ){
        if(cur.length()==2*n){
            ans.add(cur);
            return;
        }
        if(open<n){
            helper(cur+"(" , open+1 ,close ,ans, n);
        }
        if(close<open){
            helper(cur+")" , open ,close+1 , ans ,n);
        }
    }
}