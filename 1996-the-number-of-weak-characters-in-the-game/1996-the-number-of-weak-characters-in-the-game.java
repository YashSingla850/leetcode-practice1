class Solution {
    public int numberOfWeakCharacters(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });
        Stack<Integer>st = new Stack<>();
        st.push(arr[0][1]);
        int count =0;
        for(int i = 1 ;i<arr.length;i++){
            while(st.size()>0 &&  st.peek()<arr[i][1]){
                st.pop();
                count++;
            }
            st.push(arr[i][1]);
        }
        return count;
    }
}