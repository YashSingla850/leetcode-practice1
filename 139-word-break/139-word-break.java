class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] tp = new int[n];
        Arrays.fill(tp, -1);
        HashSet<String> hs = new HashSet<String>(wordDict);
        return helper(0, n, s, hs, tp);
    }
    
    public boolean helper(int pos, int n, String s, HashSet<String> hs, int[] tp){
        if(pos>=n) return true;
        if(tp[pos]!=-1) return tp[pos]==1 ? true : false;
        for(int i=pos+1;i<=n;i++){
            if(hs.contains(s.substring(pos, i)) && helper(i, n, s, hs, tp)){
                tp[pos] = 1;
                return true;
            }
        }
        tp[pos] = 0;
        return false;
    }
}


// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         HashSet<String>set = new HashSet<>();
//         for(String si:wordDict){
//             set.add(si);
//         }
//         return helper(s , "" , set);
//     }
//     public boolean helper(String s , String asf , HashSet<String>set){
//         if(s.length()==0){
//             return true;
//         }
//         for(int i= 1 ;i<=s.length();i++){
//             String smallStr = s.substring(0,i);
//             if(set.contains(smallStr)){
//                 if(helper(s.substring(i),asf+smallStr+"" , set)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }