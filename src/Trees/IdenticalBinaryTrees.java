package Trees;

import java.util.Stack;

public class IdenticalBinaryTrees {

    // 1 - true, 0 - false
    public int isSameTree(TreeNode A, TreeNode B) {
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();

        stackA.push(A);
        stackB.push(B);

        while (!stackA.isEmpty()) {
            TreeNode nodeA = stackA.pop();
            TreeNode nodeB = stackB.pop();

            if (nodeA == null && nodeB == null) {
                continue;
            } else if (nodeA == null || nodeB == null) {
                return 0;
            } else if (nodeA.val != nodeB.val) {
                return 0;
            }

            stackA.push(nodeA.left);
            stackA.push(nodeA.right);

            stackB.push(nodeB.left);
            stackB.push(nodeB.right);
        }

        return stackB.isEmpty() ? 1 : 0;
    }

    //recursively
    public int isSameTree2(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        } else if (A == null || B == null) {
            return 0;
        }

        int equals = (A.val == B.val) ? 1 : 0;
        int left = isSameTree2(A.left, B.left);
        int right = isSameTree2(A.right, B.right);

        return (equals == 1 && left == 1 && right == 1) ? 1 : 0;
    }

    public static void main(String[] args) {}
}
