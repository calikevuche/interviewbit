package Trees;

import java.util.Stack;

public class IdenticalBinaryTrees {

    // 1 - true, 0 - false
    public int isSameTree(TreeNode A, TreeNode B) {
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        stackA.push(A);
        stackB.push(B);

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
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
        return stackA.isEmpty() && stackB.isEmpty() ? 1 : 0;
    }

    //recursively
    public int isSameTree2(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        if (isSameTree2(A.left, B.left) == 0) {
            return 0;
        }
        return isSameTree2(A.right, B.right);
    }

    public static void main(String[] args) {}
}
