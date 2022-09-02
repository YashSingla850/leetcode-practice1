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
    public List<Double> averageOfLevels(TreeNode root) {
        // if(root==null){
        //     return 
        // }
        Queue<TreeNode>q = new ArrayDeque<>();
        List<Double>list   = new ArrayList<>();
      
        q.add(root);
        while(q.size()>0){
            int n = q.size();
            double sum = 0.0;
            for(int i =0 ; i<n ;i++){
                TreeNode temp =  q.poll();
                sum+=temp.val;
                if(temp.left!=null){
                   q.add(temp.left); 
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            list.add(sum/n);
        }
        return list;
    }
}