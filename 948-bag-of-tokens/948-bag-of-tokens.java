class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
   
        if(n==0)return 0;
        int i = 0;
        int j = tokens.length-1;
        int max = 0;
        int count =0;
        while(i<=j){
            if(power-tokens[i]>=0){
                count++;
              power=  power-tokens[i];
               max = Math.max(max , count);
                i++;
            }else if(count>=1){
                    power+=tokens[j];
                    count--;
                    j--;
                }else{
                break;
            }
            
        }
        return max;
    }
}