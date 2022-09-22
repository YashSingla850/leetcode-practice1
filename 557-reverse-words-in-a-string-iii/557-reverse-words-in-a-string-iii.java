class Solution {
    public String reverseWords(String s) {
        String [] arr = s.split(" ");
        String ans = "";
        for(int i =0 ; i<arr.length-1;i++){
            StringBuilder sb = new StringBuilder(arr[i]).reverse();
            ans = ans+sb.toString()+" ";  
        }
        StringBuilder si = new StringBuilder(arr[arr.length-1]).reverse();
        ans = ans+si.toString();
        return ans;
    }
}


// class Solution {
//     public String reverseWords(String s) {
//        String arr[] =  s.split(" ");
//         String ans[] = new String [arr.length];
//         for(int i = 0 ; i<arr.length;i++){
//             String si = arr[i];
//             StringBuilder sb = new StringBuilder();
//             for(int j = si.length()-1 ; j>=0 ;j--){
//                 sb.append(si.charAt(j));
//             }
//             ans[i] = sb.toString();
//         }
//         return ans.toString();
//     }
// }