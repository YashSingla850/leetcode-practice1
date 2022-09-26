class Solution {
    class Node{
        Node[]arr = new Node[26];
        boolean eow = false;
    }
    Node root  = new Node();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        for(String word :words){
            Node temp = root;
            for(char ch : word.toCharArray()){
                if(temp.arr[ch-'a']==null){
                    temp.arr[ch-'a']=new Node();
                }
                temp = temp.arr[ch-'a'];
            }
            temp.eow = true;
        }
    List<String>list = new ArrayList<>();
        for(String word : words){
            if(helper(word , 0 , 0)){
                list.add(word);
            }
        }
        return list;
    }
    boolean helper(String word ,  int i, int count){
        if(i==word.length()){
            if(count>=2){
                return true;
            }
        }
        Node temp = root;
        
        for(int j = i ; j<word.length();j++){
            char ch = word.charAt(j);
            if(temp.arr[ch-'a']==null){
                return false;
            }
            temp = temp.arr[ch-'a'];
            if(temp.eow==true){
                boolean res  = helper(word , j+1 , count+1);
                if(res==true){
                    return true;
                }
            }
        }
        return false;
    }
}