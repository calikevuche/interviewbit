package Trees;

public class SymmetricBinaryTree {

    // 0 for false, 1 for true

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isSymmetric(A.left, A.right);
    }

    private int isSymmetric(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        if (isSymmetric(A.left, B.right) == 0) {
            return 0;
        }
        return isSymmetric(A.right, B.left);
    }

    public static void main(String[] args) {
    }
}
