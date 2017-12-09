package Trees;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }

    public static void main(String[] args) { }
}
