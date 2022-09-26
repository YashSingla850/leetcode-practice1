class Solution {
    class Node{
        Node []arr = new Node[26];
        boolean eow=false;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for(String word : dictionary){
            Node temp = root;
            for(char ch : word.toCharArray()){
                 if(temp.arr[ch-'a']==null){
                     temp.arr[ch-'a'] = new Node();
                 }
                temp = temp.arr[ch-'a'];
            }
            temp.eow = true;
        }
        String []words = sentence.split(" ");
        for(int i = 0; i<words.length;i++){
            String word = words[i];
            Node temp = root;
            for(int j = 0 ; j<word.length();j++){
                char ch = word.charAt(j);
                if(temp.arr[ch-'a']==null){
                    break;
                }else{
                    temp = temp.arr[ch-'a'];
                    if(temp.eow){
                        words[i] = word.substring(0,j+1);
                        break;
                    }
                }
            }
        }
        return String.join(" ",words);
    }
}