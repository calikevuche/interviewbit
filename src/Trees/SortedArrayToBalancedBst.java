package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBst {

    public TreeNode sortedArrayToBST(List<Integer> A) {
        if (A.size() == 0) {
            return null;
        }
        if (A.size() == 1) {
            return new TreeNode(A.get(0));
        }

        int rootId = A.size() / 2;
        TreeNode root = new TreeNode(A.get(rootId));
        root.left = sortedArrayToBST(A.subList(0, rootId));
        root.right = sortedArrayToBST(A.subList(rootId + 1, A.size()));
        return root;
    }

    public TreeNode sortedArrayToBST2(List<Integer> A) {
        if (A == null || A.isEmpty()) {
            return null;
        }
        return getBST(A, 0, A.size() - 1);
    }

    private TreeNode getBST(List<Integer> A, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(A.get(mid));
        node.left = getBST(A, start, mid - 1);
        node.right = getBST(A, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,4,8));
        SortedArrayToBalancedBst ins = new SortedArrayToBalancedBst();
        TreeNode root = ins.sortedArrayToBST2(list);
    }
}
