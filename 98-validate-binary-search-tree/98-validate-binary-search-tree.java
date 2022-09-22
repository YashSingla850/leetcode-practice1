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
    public boolean isValidBST(TreeNode root) {
        List<Integer>list = new ArrayList<>();
            helper(root,list);
        
        for(int i =1 ; i<list.size();i++){
            if(list.get(i-1)>=list.get(i)){
                return false;
            }
        }
        return true;
    }
    public void  helper(TreeNode node,List<Integer>ans){
        if(node==null)return;
        helper(node.left,ans);
        ans.add(node.val);
        helper(node.right,ans);
        
    }
}