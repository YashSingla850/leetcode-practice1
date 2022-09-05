/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
         List<List<Integer>>ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
       
        
        
        while(q.size()>0){
        List<Integer>vl = new ArrayList<>();
            int n = q.size();
            for(int i = 0 ; i<n ;i++){
                Node temp = q.remove();
                vl.add(temp.val);
                if(temp.children!=null){
                    for(Node ni: temp.children){
                        q.add(ni);
                    }
                }
            }
            ans.add(vl);
           
    }
         return ans;
}
}