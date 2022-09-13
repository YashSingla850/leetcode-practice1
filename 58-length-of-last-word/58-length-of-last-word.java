class Solution {
    public int lengthOfLastWord(String s) {
        String []arr = s.split(" ");
        int n = arr.length;
        String str = arr[n-1];
         return str.length();
           
        
        
    }
}