package Trees;

import java.util.*;

public class RootToLeafPathsWithSum {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Map<TreeNode, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, new ArrayList<>(Collections.singletonList(root.val)));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null &&
                    node.right == null) {
                if (getSum(map.get(node)) == sum) {
                    result.add(map.get(node));
                }
                continue;
            }
            if (node.left != null) {
                ArrayList<Integer> arrayList = new ArrayList<>(map.get(node));
                arrayList.add(node.left.val);
                map.put(node.left, arrayList);
                queue.add(node.left);
            }
            if (node.right != null) {
                ArrayList<Integer> arrayList = new ArrayList<>(map.get(node));
                arrayList.add(node.right.val);
                map.put(node.right, arrayList);
                queue.add(node.right);
            }
        }

        return result;
    }

    private int getSum(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int val : arrayList) {
            sum += val;
        }
        return sum;
    }

    // recursion

    public ArrayList<ArrayList<Integer>> pathSum2(TreeNode root, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPathSum(arrayList, result, root, sum);
        return result;
    }

    private void findPathSum(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, TreeNode node, int sum) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        if (node.left != null) {
            findPathSum(list, result, node.left, sum - node.val);
        }
        if (node.right != null) {
            findPathSum(list, result, node.right, sum - node.val);
        }
        list.remove(list.size() - 1);
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
        root.right.right.left = new TreeNode(5);

        RootToLeafPathsWithSum instance = new RootToLeafPathsWithSum();
        instance.pathSum2(root, 22);
    }
}
