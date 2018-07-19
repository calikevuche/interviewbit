package Trees;

public class MaxDepthOfBinaryTree {

    private int result = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root, result + 1);
        return result;
    }

    private void maxDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null && depth > result) {
            result = depth;
        }
        if (node.left != null) {
            maxDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            maxDepth(node.right, depth + 1);
        }
    }


    public int maxDepth2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth2(node.left), maxDepth2(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        MaxDepthOfBinaryTree instance = new MaxDepthOfBinaryTree();
        instance.maxDepth(root);
    }
}
