class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0 ;
        for(int i  =0 ; i<32;i++){
            boolean ai = false , bi = false , ci = false;
            if((a&(1<<i))>0) ai = true;
            if((b&(1<<i))>0) bi = true;
            if((c&(1<<i))>0) ci = true;
            
            if(ci == true){
                if(!ai && !bi) count++;
            }else{
                if(ai&&bi){
                    count+=2;
                }else if(ai || bi){
                    count++;
                }
            }
        }
        return count;
    }
}