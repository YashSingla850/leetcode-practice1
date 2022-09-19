class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int prefixSum [] = new int[arr.length];
        int ans[] = new int[queries.length];
         prefixSum[0] = arr[0];
        for(int i =1 ; i<arr.length;i++){
            prefixSum[i] = prefixSum[i-1]^arr[i];
        }
        for(int i =0 ; i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if(left!=0){
            ans[i] = prefixSum[right] ^prefixSum[left-1];
            }else{
                ans[i] = prefixSum[right];
            }
        }
        return ans;
    }
}