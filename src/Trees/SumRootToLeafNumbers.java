package Trees;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return sum(A, 0, 1003);
    }

    private int sum(TreeNode node, int num, int mask) {
        num = (num * 10 + node.val) % mask;
        if (node.left == null && node.right == null) {
            return num;
        }
        int leftSum = 0, rightSum = 0;
        if (node.left != null) {
            leftSum = sum(node.left, num, mask);
        }
        if (node.right != null) {
            rightSum = sum(node.right, num, mask);
        }
        return (leftSum + rightSum) % mask;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        SumRootToLeafNumbers ins = new SumRootToLeafNumbers();
        System.out.println(ins.sumNumbers(root));
    }
}
