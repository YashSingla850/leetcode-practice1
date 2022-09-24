/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        if(root==null)return ans;
         Stack<List<Integer>>st = new Stack<>();
          Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            List<Integer>list = new ArrayList<>();
            int  n= q.size();
            for(int i =0  ; i<n ; i++){
                TreeNode temp = q.remove(); 
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                list.add(temp.val);
            }
            st.add(list);
            
        }
        while(st.size()>0){
            ans.add(st.pop());
        }
         return ans;
    }
}