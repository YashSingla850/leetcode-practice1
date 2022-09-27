class Solution {
    class Node{
        Node [] arr = new Node[26];
        int count = 0;
    }
    void insert(int num){
        Node temp = root;
        for(int i = 15 ; i>=0 ; i--){
            int bit = (num & (1<<i))==0?0 :1;
            if(temp.arr[bit]==null){
                temp.arr[bit] = new Node();
            }
            temp = temp.arr[bit];
            temp.count++;
        }
        
    }
    
    int helper(int a ,int k){
        int countnum = 0 ; 
        Node temp = root;
        for(int i= 15 ; i>=0 ;i--){
            int kbit = (k &(1<<i))==0 ?0 :1;
            int bit = (a &(1<<i))==0 ?0 :1;
            int rbit = Math.abs(bit-1);
            if(kbit==1){
                if(temp.arr[bit]!=null){
                    countnum += temp.arr[bit].count;
                }
                temp = temp.arr[rbit];
            }else{
                temp = temp.arr[bit];
            }
            if(temp==null){
                break;
            }
        }
        return countnum;
    }
    Node root =  new Node();
    public int countPairs(int[] nums, int low, int high) {
        int res = 0 ;
        for(int num : nums){
            res+=helper(num , high+1) - helper(num , low);
            insert(num);
        }
        return res;
    }
}