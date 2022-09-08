class Solution {
    public boolean isSubsequence(String s, String t) {
        int i =0 ,j =0;
        int n = s.length(), m  = t.length();
        while(i<n && j<m){
            char ch = s.charAt(i);
            char ch1 = t.charAt(j);
            if(ch==ch1){
                i++;
                j++;
            }else{
                j++;
            }
            
        }
        if(i==n){
            return true;
        }
        return false;
    }
}