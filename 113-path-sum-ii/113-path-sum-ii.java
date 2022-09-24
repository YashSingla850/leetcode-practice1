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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>list = new ArrayList<>();
        helper(root , targetSum , list,new ArrayList<Integer>());
        return list;
    }
    public void helper(TreeNode node,  int target , List<List<Integer>>ans , List<Integer>list){
        if(node==null)return;
        if(node.left==null&& node.right==null){
            if(node.val-target==0){
                list.add(node.val);
                ans.add(list);
            }
            return;
        }
        list.add(node.val);
        target-=node.val;
        helper(node.left,target , ans ,new ArrayList<>(list));;
        helper(node.right , target , ans ,new ArrayList<>(list));
    }
}