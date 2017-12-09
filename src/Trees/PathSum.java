package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PathSum {

    public int hasPathSum(TreeNode root, int sum) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null &&
                    node.right == null) {
                if (map.get(node) == sum) {
                    return 1;
                }
                continue;
            }
            if (node.left != null) {
                map.put(node.left, map.get(node) + node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, map.get(node) + node.right.val);
                queue.add(node.right);
            }
        }

        return 0; // 0 - false, 1 - true
    }

    // recursion without HashMap

    public int hasPathSum2(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.left == null &&
                node.right == null &&
                node.val == sum) {
            return 1;
        }
        int left = 0, right = 0;
        if (node.left != null) {
            left = hasPathSum2(node.left, sum - node.val);
        }
        if (node.right != null) {
            right = hasPathSum2(node.right, sum - node.val);
        }
        return (left + right == 0) ? 0 : 1;
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

        PathSum instance = new PathSum();
        instance.hasPathSum2(root, 22);
    }
}
