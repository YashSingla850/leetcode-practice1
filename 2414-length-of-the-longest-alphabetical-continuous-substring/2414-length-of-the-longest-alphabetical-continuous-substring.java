class Solution {
    public int longestContinuousSubstring(String s) {
        char []arr = s.toCharArray();
        int count =1;
        int max = 1;
        int j = 0;
        for(int i  = 1 ; i<arr.length;i++){
            if((arr[i]-'a')-1 == arr[i-1]-'a'){
                count++;
                max  = Math.max(max,count);
            }else{
                count =1;
            }
        }
        return max;
    }
}