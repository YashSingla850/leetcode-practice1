/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
         helperS(root , sb);
        return sb.toString();
    }
    public void helperS(TreeNode node , StringBuilder sb){
        if(node==null){
            sb.append("null,");
            return;
        }
        sb.append(node.val+",");
        helperS(node.left,sb);
        helperS(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String []arr = data.split(",");
        return  helperD(arr);
    }
    public int idx = 0;
    public TreeNode helperD(String []arr){
        if(idx>=arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode nodei = new TreeNode(Integer.parseInt(arr[idx++]));
        nodei.left = helperD(arr);
        nodei.right = helperD(arr);
        return nodei;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));