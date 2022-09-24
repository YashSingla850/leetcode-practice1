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
    int min = (int)1e9;
    public int minDepth(TreeNode root) {
     min = (int)1e9;
        if(root==null)return 0;
                helper(root,1);
        return min;
    }
    public void helper(TreeNode node , int count){
        if(node==null)return;
        if(node.left==null && node.right==null){
            min =Math.min(count , min); 
            return ;
        }
        helper(node.left , count+1);
        helper(node.right , count+1);
    }
}