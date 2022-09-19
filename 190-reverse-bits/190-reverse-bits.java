public class Solution {
public int reverseBits(int n) {
        int result = 0;
        
        for(int i=0;i<32;i++) {
            int bit = (n >> i) & 1;
            result = result | (bit << (31-i));
        }
        return result;
    }
}

// public class Solution {
//     // you need treat n as an unsigned value
//     public int reverseBits(int n) {
//         boolean flag  = false;
//         int rev = 0 ;
//         int j = 0 ;
//         for(int i = 31;i>=0 ; i--){
//             int mask= (1<<i);
//             if(flag==true){
//                 if((n&mask)!=0){
//                     int smask = (1<<j);
//                     rev |=smask;
//                 }else{
                    
//                 }
//                 j++;
//             }else{
//                 if((n&mask)!=0){
//                     flag = true;
//                     int smask = (i<<j);
//                     rev|=smask;
//                     j++;
//                 }
//             }
//         }
//         return rev;
//     }
// }