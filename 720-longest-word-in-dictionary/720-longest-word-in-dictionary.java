class Solution {
    class Node{
        boolean eow = false;
        Node []arr = new Node[26];
    }
    String res ;
    public String longestWord(String[] words) {
        res = "";
        Node root = new Node();
        
        for(String word:words){
            Node temp = root;
            for(char ch : word.toCharArray()){
                if(temp.arr[ch-'a']==null){
                    temp.arr[ch-'a'] = new Node();
                }
                temp = temp.arr[ch-'a'];
            }
            temp.eow = true;
        }
        
        helper(root , new StringBuilder());
            return res;
        }
         void helper(Node node , StringBuilder sb){
            if(sb.length()>res.length()){
                res = sb.toString();
            }
            for(char ch = 'a' ; ch <='z'; ch++){
              Node child =  node.arr[ch-'a'];
                if(child!=null && child.eow==true){
                    sb.append(ch);
                    helper(child,sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    
}