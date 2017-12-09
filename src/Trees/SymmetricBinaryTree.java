package Trees;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isSymmetric(A.left, A.right);
    }

    private int isSymmetric(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        } else if (A == null || B == null) {
            return 0;
        }

        int equals = A.val == B.val ? 1 : 0;
        int sym1 = isSymmetric(A.left, B.right);
        int sym2 = isSymmetric(A.right, B.left);

        return equals == 1 && sym1 == 1 & sym2 == 1 ? 1 : 0;
    }

    public static void main(String[] args) { }
}
