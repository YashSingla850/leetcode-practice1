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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        if(root == null)    return ans;
        boolean leftToRight = true;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty())
        {
            List<Integer> curr = new ArrayList<>();
            int qSize = Q.size();
            for(int i=0;i<qSize;i++)
            {
                TreeNode node = Q.poll();
                if(leftToRight)    curr.add(node.val);
                else    curr.add(0,node.val);
                if(node.left != null)   Q.offer(node.left);
                if(node.right != null)   Q.offer(node.right);
            }
            leftToRight = !leftToRight;
            ans.add(curr);
        }
        return ans;
    }
}


// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         int count =-1 ; 
//         List<List<Integer>>ans =new ArrayList<>();
//         Queue<TreeNode>q= new ArrayDeque<>();
//         if(root==null)return ans;
//         q.add(root);
//         while(q.size()>0){
//             int n  = q.size();
//             count++;
//             List<Integer>list = new ArrayList<>();
//             for(int i = 0  ; i<n ;i++){
//                 TreeNode temp = q.remove();
//                 if(count%2==0){
//                     if(temp.right!=null){
//                         q.add(temp.right);
//                     }
//                     if(temp.left!=null){
//                         q.add(temp.left);
//                     }
//                 }else{
//                      if(temp.left!=null){
//                         q.add(temp.left);
//                     }
//                     if(temp.right!=null){
//                         q.add(temp.right);
//                     }
//                 }
//                 list.add(temp.val);
//             }
//             ans.add(list);
//         }
//         return ans;
//     }
// }