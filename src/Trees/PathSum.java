package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PathSum {

    // return 0 - false, 1 - true

    public int hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, root.val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null && map.get(node) == sum) {
                return 1;
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
        return 0;
    }

    public int hasPathSum2(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && node.val == sum) {
            return 1;
        }
        if (node.left != null &&
                hasPathSum2(node.left, sum - node.val) == 1) {
            return 1;
        }
        if (node.right != null &&
                hasPathSum2(node.right, sum - node.val) == 1) {
            return 1;
        }
        return 0;
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
