class Solution {
    public int[] processQueries(int[] arr, int m) {
    List<Integer>list= new ArrayList<>();
    List<Integer>ans = new ArrayList<>();
        for(int i =1 ; i<=m ; i++){
            list.add(i);
        }
        for(int i =0 ;i<arr.length;i++){
            int val = list.indexOf(arr[i]);
            ans.add(val);
            list.remove(val);
            list.add(0 , arr[i]);
        }
        int []ans1 = new int[arr.length];
       for(int i =0 ; i<arr.length;i++){
           ans1[i] = ans.get(i);
       }
        return ans1;
    }
}