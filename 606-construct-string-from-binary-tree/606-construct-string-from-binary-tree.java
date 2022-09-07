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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
         helper(root , sb);
        return sb.toString();
    }
    public void helper(TreeNode node , StringBuilder sb){
        
        sb.append(node.val);
        if(node.left!=null){
        sb.append('(');
        helper(node.left,sb);
        sb.append(')');
        }else if(node.right!=null){
            sb.append("()");
        }
          if(node.right!=null){
              sb.append('(');
              helper(node.right, sb);
              sb.append(')');
          }
      
    }
}