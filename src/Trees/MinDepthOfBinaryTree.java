package Trees;

public class MinDepthOfBinaryTree {

    public int minDepth(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.right == null) {
            return 1 + minDepth(node.left);
        }
        if (node.left == null) {
            return 1 + minDepth(node.right);
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }
}
