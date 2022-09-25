class MapSum {
    class Node{
        Node []children = new Node[26];
        int val =0;
    }
    Node root;

    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node temp = root;
        for(char ch : key.toCharArray()){
            if(temp.children[ch-'a']==null){
                temp.children[ch-'a'] = new Node();
            }
            temp = temp.children[ch-'a'];
        }
        temp.val = val;
    }
    
    int sum ;
    public int sum(String prefix) {
        Node temp = root;
        for(char ch: prefix.toCharArray()){
            if(temp.children[ch-'a']==null){
                return 0;
            }
            temp =temp.children[ch-'a'];
        }
        sum =0 ;
        helper(temp);
        return sum;
    }
    void helper(Node node){
        sum +=node.val;
        for(Node child:node.children){
            if(child!=null){
                helper(child);
            }
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */