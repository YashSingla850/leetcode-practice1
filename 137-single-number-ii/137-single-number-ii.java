class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0 ;
        for(int i =0; i<nums.length;i++){
            a = (a^nums[i]&(~b));
            b = (b^nums[i]&(~a));
        }
        return a;
    }
}



//  my solution failed for negative test cases
// class Solution {
//     public int singleNumber(int[] nums) {
//         int tn= Integer.MAX_VALUE , tnp1 =0  , tnp2 = 0;
//         for(int i = 0 ; i<nums.length ; i++){
//             int cwtn = tn & nums[i];
//             int cwtnp1  = tnp1 & nums[i];
//             int cwtnp2 = tnp2 &nums[i];
            
//             tn = tn &(~cwtn);
//             tnp1 = tnp1 | cwtn;
            
//              tnp1 = tnp1 &(~cwtnp1);
//             tnp2 = tnp2 | cwtnp1;
            
            
//             tnp2 = tnp2 & (~cwtnp2);
//             tn = tn | cwtnp2;
//         }
//         return tnp1;
//     }
// }