package Graphs;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public int[][] levelOrder(TreeNode A) {
        if (A == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(A);
        while (!queue1.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue1.remove();
                arrayList.add(node.val);
                if (node.left != null) {
                    queue1.add(node.left);
                }
                if (node.right != null) {
                    queue1.add(node.right);
                }
            }
            resultList.add(arrayList);
        }
        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            int[] level = new int[resultList.get(i).size()];
            for (int j = 0; j < resultList.get(i).size(); j++) {
                level[j] = resultList.get(i).get(j);
            }
            result[i] = level;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);

        LevelOrder instance = new LevelOrder();
        instance.levelOrder(A);
    }
}
