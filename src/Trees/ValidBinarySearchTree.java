package Trees;

public class ValidBinarySearchTree {

    // 0 - false, 1 - true
    public int isValidBST(TreeNode A) {
        return isValidBSTBoolean(A) ? 1 : 0;
    }

    public boolean isValidBSTBoolean(TreeNode root) {
        return root == null ||
                isSubTreeLesser(root.left, root.val) &&
                        isSubTreeGreater(root.right, root.val) &&
                        isValidBSTBoolean(root.left) &&
                        isValidBSTBoolean(root.right);
    }

    private boolean isSubTreeLesser(TreeNode node, int value) {
        return node == null ||
                node.val < value &&
                        isSubTreeLesser(node.left, value) &&
                        isSubTreeLesser(node.right, value);
    }

    private boolean isSubTreeGreater(TreeNode node, int value) {
        return node == null ||
                node.val > value &&
                        isSubTreeGreater(node.left, value) &&
                        isSubTreeGreater(node.right, value);
    }

    // FASTER SOLUTION

    // 0 - false, 1 - true
    public int isValidBST2(TreeNode A) {
        return isValidBSTEfficient(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBSTEfficient(TreeNode node, int minValue, int maxValue) {
        return node == null ||
                node.val > minValue && node.val < maxValue &&
                        isValidBSTEfficient(node.left, minValue, node.val) &&
                        isValidBSTEfficient(node.right, node.val, maxValue);
    }
}