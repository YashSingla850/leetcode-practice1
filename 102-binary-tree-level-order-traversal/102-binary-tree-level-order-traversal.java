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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>>ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            List<Integer>list =  new ArrayList<>();
            int n  =  q.size();
            for(int i = 0 ; i<n ; i++){
                TreeNode temp = q.remove();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                list.add(temp.val);
            }
            ans.add(list);
        }
        return ans;
    }
}




// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>>ans = new LinkedList<>();
//         List<Integer>list = new LinkedList<>();
//         Queue<TreeNode>queue  = new ArrayDeque<>();
//         queue.add(root);
//         queue.add(null);
//         while(queue.size()>0){
//             TreeNode temp  = queue.remove();
            
//             if(temp!= null){
//                 list.add(temp.val);
                
//                 if(temp.left!=null){
//                     queue.add(temp.left);
//                 }
//                 if(temp.right!=null){
//                     queue.add(temp.right);
//                 }
//             }else{
//                 ans.add(list);
//                 list.clear();
//                 if(queue.size()>0){
//                 queue.add(null);
//                 }
//             }
//         }
//         return ans;
//     }
// }