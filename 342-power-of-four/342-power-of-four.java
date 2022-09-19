class Solution {
    public boolean isPowerOfFour(int n) {
        while(n!=1){
            if(n<4){
                return false;
            }
            if(n%4!=0){
                return false;
            }else{
            n = n/4;
          }
        }
        return true;
    }
}