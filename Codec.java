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
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder strB = new StringBuilder();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                strB.append(null + ",");
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
            strB.append(node.val + ",");
        }
        return strB.toString();
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) 
            return null;
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = new TreeNode(Integer.valueOf(list.pop()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!list.isEmpty()) {
            TreeNode pare = queue.poll();
            
            if (list.peek().equals("null")) {
                list.pop();
            } else {
                TreeNode left = new TreeNode(Integer.valueOf(list.pop()));
                pare.left = left;
                queue.offer(left);
            }

            if (list.peek().equals("null")) {
                list.pop();
            } else {
                TreeNode right = new TreeNode(Integer.valueOf(list.pop()));
                pare.right = right;
                queue.offer(right);
            }

        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
