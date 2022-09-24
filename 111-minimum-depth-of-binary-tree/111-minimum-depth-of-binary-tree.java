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
    public int minDepth(TreeNode root) {
        Queue<TreeNode>q = new ArrayDeque<>();
        if(root==null)return 0;
        q.add(root);
        int count =1;
        while(q.size()>0){
            int n = q.size();
            for(int i  = 0 ; i<n ;i++){
                TreeNode temp = q.remove();
                if(temp.left==null && temp.right==null){
                    return count;
                }
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
           count++;
        }
        return 0;
    }
}


// class Solution {
//     int min = (int)1e9;
//     public int minDepth(TreeNode root) {
//      min = (int)1e9;
//         if(root==null)return 0;
//                 helper(root,1);
//         return min;
//     }
//     public void helper(TreeNode node , int count){
//         if(node==null)return;
//         if(node.left==null && node.right==null){
//             min =Math.min(count , min); 
//             return ;
//         }
//         helper(node.left , count+1);
//         helper(node.right , count+1);
//     }
// }