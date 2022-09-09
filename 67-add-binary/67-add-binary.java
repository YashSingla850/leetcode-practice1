class Solution {
    public String addBinary(String a, String b) {
       int i = a.length()-1  ,  j = b.length()-1;
        int carry =0 ;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int sum = carry ;
            if(i>=0){
                sum+= a.charAt(i)-'0';
             
            }
            if(j>=0){
                sum+=b.charAt(j)-'0';
              
            }
            sb.append(sum%2);
            carry= sum/2;
              j--;
               i--;
        }
        if(carry!=0)sb.append(carry);
        sb.reverse();
        return sb.toString();
    }
}


// class Solution {
//     public String addBinary(String a, String b) {
//         int sum = 0; 
//         int count =0;
//         int n =  a.length();
//         int m  = b.length();
//         for(int i = n-1; i>=0 ;i--){
//             char ch = a.charAt(i);
//             if(ch=='1'){
//                 sum+=Math.pow(2,count);
//             }
//             count++;
//         }
//         count =0;
//          for(int i = m-1; i>=0 ;i--){
//             char ch = b.charAt(i);
//             if(ch=='1'){
//                 sum+=Math.pow(2,count);
//             }
//             count++;
//         }
//         String ans = Integer.toBinaryString(sum);
//         return ans;
//     }
// }