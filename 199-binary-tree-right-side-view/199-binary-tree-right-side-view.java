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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>rans = new ArrayList<>();
        if(root==null)return rans;
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int n = q.size();
            List<Integer>list = new ArrayList<>();
            for(int i = 0; i<n ; i++){
                TreeNode temp = q.remove();
                 list.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            ans.add(list);
        }
        for(int i = 0 ; i<ans.size();i++){
            List<Integer>te = ans.get(i);
            rans.add(te.get(te.size()-1));
        }
        return rans;
    }
}