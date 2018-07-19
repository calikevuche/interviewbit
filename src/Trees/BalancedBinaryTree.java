package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {

    // 0 - false, 1 - true

    public int isBalanced(TreeNode node) {
        if (node == null) {
            return 1;
        }
        if (Math.abs(maxDepth(node.left) - maxDepth(node.right)) < 2 &&
                isBalanced(node.left) == 1 &&
                isBalanced(node.right) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int isBalanced2(TreeNode node) {
        if (node == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                continue;
            }
            queue.add(current.left);
            queue.add(current.right);
            if (Math.abs(maxDepth(current.left) - maxDepth(current.right)) > 1) {
                return 0;
            }
        }
        return 1;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    // With pair

    class Pair {
        int first = 0;
        boolean second = false;

        Pair(int first, boolean second) {
            this.first = first;
            this.second = second;
        }
    }

    public int isBalanced3(TreeNode node) {
        return isBalancedWithDepth(node).second ? 1 : 0;
    }

    private Pair isBalancedWithDepth(TreeNode node) {
        if (node == null) {
            return new Pair(0, true);
        }
        Pair left = isBalancedWithDepth(node.left);
        Pair right = isBalancedWithDepth(node.right);
        int depth = 1 + Math.max(left.first, right.first);
        boolean isBalanced = left.second && right.second &&
                Math.abs(left.first - right.first) < 2;
        return new Pair(depth, isBalanced);
    }
}
