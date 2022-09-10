class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String>map  =  new HashMap<>();
        List<String>list = new ArrayList<>();
        int n = digits.length();
        if(n==0)return list;
         String s[] = {"abc" , "def" ,"ghi" ,"jkl" ,"mno","pqrs" ,"tuv","wxyz"};
        for(int i = 0 ; i<s.length;i++){
            map.put(i+2 , s[i]);
        }
           helper("" ,n , 0 , map , digits ,list );
        return list;
    }
    public void helper(String ns , int n , int start , HashMap<Integer,String>map , String s , List<String>list){
        if(start==n){
            list.add(new String(ns));
            return;
        }
        int nt = s.charAt(start)-'0';
        String stemp = map.get(nt);
        for(int i = 0 ;i<stemp.length();i++){
            ns+=stemp.charAt(i);
            helper(ns , n , start+1 , map , s , list);
            ns = ns.substring(0,ns.length()-1);
        }
    }
}