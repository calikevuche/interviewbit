package Trees;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    // O(N * logN)

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        Map<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        breadthFirstSearch(root, treeMap);
        return new ArrayList<>(treeMap.values());
    }

    private void breadthFirstSearch(TreeNode root, Map<Integer, ArrayList<Integer>> treeMap) {
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

    // O(N)

    private static final int MIN = 0;
    private static final int MAX = 1;

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        int[] minMax = breadthFirstSearch2(root, hashMap);
        for (int i = minMax[MIN]; i <= minMax[MAX]; i++) {
            result.add(hashMap.get(i));
        }
        return result;
    }

    private int[] breadthFirstSearch2(TreeNode root, Map<Integer, ArrayList<Integer>> hashMap) {
        Map<TreeNode, Integer> distancesMap = new HashMap<>();
        distancesMap.put(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int min = 0, max = 0;

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
            ArrayList<Integer> nodes = hashMap.getOrDefault(distance, new ArrayList<>());
            nodes.add(node.val);
            hashMap.put(distance, nodes);
            min = Math.min(min, distance);
            max = Math.max(max, distance);
        }

        int[] minMax = new int[2];
        minMax[MIN] = min;
        minMax[MAX] = max;
        return minMax;
    }
}
