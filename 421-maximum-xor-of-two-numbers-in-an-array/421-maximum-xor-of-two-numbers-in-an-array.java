class Solution {
    class Node{
        Node [] arr = new Node[2];
    }
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int num:nums){
            Node temp = root;
            for(int i = 30 ; i>=0;i--){
                int bit = (num &(1<<i)) ==0 ?0 :1;
                if(temp.arr[bit]==null){
                    temp.arr[bit] = new Node();
                }
                temp = temp.arr[bit];
            }
        }
        int res = 0 ;
         for(int num : nums){
             int max_xor= 0 ; 
             Node temp = root;
             for(int i = 30 ; i>=0 ; i--){
                 int bit = (num & (1<<i))==0?0:1;
                 int cbit = Math.abs(bit-1);
                 if(temp.arr[cbit]!=null){
                     temp = temp.arr[cbit];
                     max_xor = max_xor | (1<<i);
                 }else{
                 temp = temp.arr[bit];
                     
                 }
             }
             res =  Math.max(res , max_xor);
         }
        return res;
    }
}