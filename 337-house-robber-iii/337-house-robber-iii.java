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
    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0] , ans[1]);
    }
    public int[] helper(TreeNode node){
        if(node==null)return new int[2];
        int [] left  =  helper(node.left);
        int [] right = helper(node.right);
        int []ans = new int[2];
//         with robbery
        ans[0] = left[1]+node.val + right[1];
//         without robbery
        ans[1] =  Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]);
        return ans;
    }
}