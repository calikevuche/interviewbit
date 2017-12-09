package Trees;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    Map<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        breadthFirstSearch(root);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.addAll(treeMap.values());

        return res;
    }

    public void breadthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        Map<TreeNode, Integer> distancesMap = new HashMap<>();
        distancesMap.put(root, 0);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                continue;
            }

            int distance = distancesMap.get(node);

            distancesMap.put(node.left, distance - 1);
            distancesMap.put(node.right, distance + 1);

            q.add(node.left);
            q.add(node.right);

            ArrayList<Integer> nodes = treeMap.getOrDefault(distance, new ArrayList<>());
            nodes.add(node.val);
            treeMap.put(distance, nodes);
        }
    }
}
