package Trees;

import java.util.Stack;

public class TwoSumBinaryTree {

    // 1 - true, 0 - false

    public int t2SumV1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;

        while (!stack.isEmpty() || n != null) {
            while (n != null) {
                stack.push(n);
                n = n.left;
            }
            n = stack.pop();
            if (sum > 2 * n.val && hasNum(root, sum - n.val)) {
                return 1;
            }
            n = n.right;
        }
        return 0;
    }

    private boolean hasNum(TreeNode node, int num) {
        if (node == null) {
            return false;
        }
        if (node.val == num) {
            return true;
        }
        if (num < node.val) {
            return hasNum(node.left, num);
        } else {
            return hasNum(node.right, num);
        }
    }

    // using iterator

    public int t2SumV2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        BSTIterator iterator = new BSTIterator(root);

        int i = iterator.next();
        int j = iterator.prev();

        while (i < j) {
            if (i + j == sum) {
                return 1;
            } else if (i + j < sum) {
                i = iterator.next();
            } else {
                j = iterator.prev();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);

        node1.left = new TreeNode(5);
        node1.right = new TreeNode(20);

        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(6);

        TwoSumBinaryTree ins = new TwoSumBinaryTree();
        int res = ins.t2SumV1(node1, 24);
    }
}
