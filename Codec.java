import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    StringBuilder strB = new StringBuilder("[");
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
    return strB.deleteCharAt(strB.length() - 1).append("]").toString();

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    TreeNode root = new TreeNode(0);
    return root;
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    Codec codec = new Codec();
    System.out.println(codec.serialize(root));
    String str = "a, b, c, null";
    String[] a = str.split(",");
    System.out.println(null == "null");
  }
}

