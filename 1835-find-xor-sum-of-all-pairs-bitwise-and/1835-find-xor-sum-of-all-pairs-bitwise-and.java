class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0;
        int xor2 =0;
        // for(int i = 0 ; i<arr1.length;i++){
        //     for(int j = 0 ; j<arr2.length ; j++){
        //         int val = (arr1[i]&arr2[j]);
        //         xor  = xor^val;
        //     }
        // }
        // return xor;
        for(int i = 0 ;i<arr2.length;i++){
            xor2 = xor2^arr2[i];
        }
        for(int i  = 0 ;i<arr1.length;i++){
            xor1 = xor1^arr1[i];
        }
        return (xor1&xor2);
    }
}