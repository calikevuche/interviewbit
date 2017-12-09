package Trees;

public class NextGreaterNumberBst {

    public TreeNode getSuccessor(TreeNode root, int value) {
        TreeNode current = findNode(root, value);
        if (current == null) {
            return null;
        }
        if (current.right != null) {
            return findMin(current.right);
        } else {
            TreeNode result = null;
            TreeNode node = root;
            while (node.val != value) {
                if (node.val > value) {
                    result = node;
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return result;
        }
    }

    private TreeNode findNode(TreeNode node, int value) {
        while (node != null) {
            if (node.val == value) {
                return node;
            } else if (node.val < value) {
                node = node.right;
            } else if (node.val > value) {
                node = node.left;
            }
        }
        return null;
    }

    private TreeNode findMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
