class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int [] checkArr = new  int[26];
         boolean[] visited = new boolean[26];
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            int val  = ch-'a';
              checkArr[val] = i;
        }
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(st.size()==0){
                st.push(ch-'a');
                visited[ch-'a']= true;
            }else{
                if(visited[ch-'a']==false){
                while(st.size()>0){
                int val = st.peek();
                    if(val>(ch-'a') && checkArr[val]>i){
                        st.pop();
                        visited[val] = false;
                    }else{
                        break;
                    }
                }
                st.push(ch-'a');
                visited[ch-'a'] = true;
            } 
          }
        }
            for(int val :st){
                char ch = (char)(val+'a');
                sb.append(ch);
            }
        return sb.toString();
    }
}

// class Solution {
//     public String removeDuplicateLetters(String s) {
//         HashSet<Character>set = new HashSet<>();
//         StringBuilder sb = new StringBuilder();
//         for(int i = 0; i<s.length();i++){
//             char ch =s.charAt(i);
//             set.add(ch);
//         }
//         for(int i = 0 ; i<26 ;i++){
//             if(set.contains((char)(i+'a'))==true){
//                 char ch =(char)(i+'a');
//                 sb.append(ch);
//             }
//         }
//         return sb.toString();
//     }
// }