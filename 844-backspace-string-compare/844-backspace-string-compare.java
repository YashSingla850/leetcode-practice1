class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = helper(s);
        String t1  =helper(t);
        return s1.equals(t1);
    }
    public String helper(String s){
        Stack<Character>st = new Stack<>();
        for(int i = 0 ; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch!='#'){
                st.push(ch);
            }else if(st.size()>0){
                st.pop();
            }
        }
        StringBuilder sb =  new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}