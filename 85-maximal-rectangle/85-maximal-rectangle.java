class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ht[] = new int[matrix[0].length];
        for(int j = 0 ; j<matrix[0].length ; j++){
            ht[j] = matrix[0][j]== '0'? 0: 1;
        }
        int res = histogram(ht);
        for(int i = 1 ;i<matrix.length ; i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                ht[j] =  matrix[i][j] == '0'?0:ht[j]+1;
            }
            int res2 = histogram(ht);
            res = Math.max(res2 , res);
        }
        return res;
    }
    public int histogram(int[]arr){
        int left[] =  helperleft(arr);
        int right[]  = helperright(arr);
        int max = 0 ;
        for(int i  =0 ;i<arr.length;i++){
            max = Math.max(max , arr[i]*(right[i]-left[i]-1));
        }
        return max;
    }
    public int[] helperright(int[]arr){
        int ans[] = new int[arr.length];
        Stack<Integer>st = new Stack<>();
        st.push(0);
        Arrays.fill(ans,arr.length);
        for(int i = 1 ; i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] helperleft(int[]arr){
        int ans [] = new int [arr.length];
        Stack<Integer>st = new Stack<>();
        st.push(arr.length-1);
        Arrays.fill(ans , -1);
        for(int i = arr.length-2 ; i>=0 ; i--){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                ans[st.peek()] = i;
                st.pop();
            }
             st.push(i);
        }
        return ans;
    }
}