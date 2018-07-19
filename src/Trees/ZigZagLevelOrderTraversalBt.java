package Trees;

import java.util.*;

public class ZigZagLevelOrderTraversalBt {

    // complicated with 2 maps

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<TreeNode>> levelListNodesMap = new HashMap<>();
        breadthFirstSearch(root, levelListNodesMap);
        ArrayList<TreeNode> nodeList = null;
        ArrayList<Integer> intList = null;
        int i = 0;
        for (int key: levelListNodesMap.keySet()) {
            nodeList = levelListNodesMap.get(key);
            intList = new ArrayList<>();
            for (TreeNode node: nodeList) {
                intList.add(node.val);
            }
            if (i % 2 != 0) {
                Collections.reverse(intList);
            }
            result.add(intList);
            i++;
        }
        return result;
    }

    private void breadthFirstSearch(TreeNode root, Map<Integer, ArrayList<TreeNode>> levelListNodesMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Map<TreeNode, Integer> nodeLevelMap = new HashMap<>();
        nodeLevelMap.put(root, 0);

        TreeNode node = null;
        int level = 0;
        ArrayList<TreeNode> arrayList;

        while (!q.isEmpty()) {
            node = q.poll();
            level = nodeLevelMap.get(node);
            if (node == null) {
                continue;
            }
            q.add(node.left);
            q.add(node.right);
            nodeLevelMap.put(node.left, level + 1);
            nodeLevelMap.put(node.right, level + 1);
            arrayList = levelListNodesMap.getOrDefault(level, new ArrayList<>());
            arrayList.add(node);
            levelListNodesMap.put(level, arrayList);
        }
    }

    // with 2 stacks

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<TreeNode> temp = null;
        stack1.push(root);

        boolean reverse = false;
        TreeNode node = null;
        ArrayList<Integer> arrayList = null;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            arrayList = new ArrayList<>();

            while (!stack1.isEmpty()) {
                node = stack1.pop();
                if (node == null) {
                    continue;
                }
                arrayList.add(node.val);
                if (reverse) {
                    stack2.push(node.right);
                    stack2.push(node.left);
                } else {
                    stack2.push(node.left);
                    stack2.push(node.right);
                }
            }

            temp = stack1;
            stack1 = stack2;
            stack2 = temp;
            reverse = !reverse;
            if (!arrayList.isEmpty()) {
                result.add(arrayList);
            }
        }
        return result;
    }

    // with 1 queue

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder3(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = null;
        boolean reverse = false;

        while (!q.isEmpty()) {
            int i = 0, size = q.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (i < size) {
                i++;
                node = q.poll();
                if (node == null) {
                    continue;
                }
                if (reverse) {
                    arrayList.add(0, node.val);
                } else {
                    arrayList.add(node.val);
                }
                q.add(node.left);
                q.add(node.right);
            }
            reverse = !reverse;
            if (!arrayList.isEmpty()) {
                result.add(arrayList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ZigZagLevelOrderTraversalBt instance = new ZigZagLevelOrderTraversalBt();
        instance.zigzagLevelOrder3(root);
    }
}
