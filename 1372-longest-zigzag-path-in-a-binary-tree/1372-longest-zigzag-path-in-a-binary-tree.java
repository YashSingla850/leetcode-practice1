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
    public class pair{
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLen = 0;
    }
    
    public int longestZigZag(TreeNode root) {
        pair  ans = helper(root);
        return ans.maxLen;
    }
    public pair helper(TreeNode node){
        if(node==null)return new pair();
        pair left = helper(node.left);
        pair right = helper(node.right);
        pair ans = new pair();
        ans.maxLen = Math.max(Math.max(left.maxLen,right.maxLen),Math.max(left.backwardSlope,right.forwardSlope)+1);
        ans.forwardSlope = left.backwardSlope+1;
        ans.backwardSlope = right.forwardSlope+1;
        return ans;
    }
}