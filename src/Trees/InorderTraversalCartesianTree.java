package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversalCartesianTree {

    public TreeNode buildTree(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) {
            return null;
        }
        return buildTree(A, 0, A.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> A, int start, int end) {
        if (start > end) {
            return null;
        }
        int id = getMaxElementIndex(A, start, end);
        int val = A.get(id);
        TreeNode newNode = new TreeNode(val);
        newNode.left = buildTree(A, start, id - 1);
        newNode.right = buildTree(A, id + 1, end);
        return newNode;
    }

    private int getMaxElementIndex(List<Integer> list, int start, int end) {
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (list.get(i) > list.get(index)) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(88,99,77,44,100,5,8,2,6));
        InorderTraversalCartesianTree instance = new InorderTraversalCartesianTree();
        TreeNode root = instance.buildTree(arrayList);
    }
}
