package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversalCartesianTree {

    public TreeNode buildTree(ArrayList<Integer> A) {
        if (A.isEmpty()) {
            return null;
        }
        return buildTreeInternal(A);
    }

    private TreeNode buildTreeInternal(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        int id = findGreaterElementId(list);
        int val = list.get(id);
        TreeNode newNode = new TreeNode(val);
        if (list.size() == 1) {
            return newNode;
        }

        newNode.left = buildTreeInternal(list.subList(0, id));
        newNode.right = buildTreeInternal(list.subList(id + 1, list.size()));
        return newNode;
    }

    private int findGreaterElementId(List<Integer> list) {
        if (list.size() == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(result)) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(88,99,77,44,100,5,8,2,6));
        InorderTraversalCartesianTree instance = new InorderTraversalCartesianTree();
        TreeNode root = instance.buildTree(arrayList);
    }
}
