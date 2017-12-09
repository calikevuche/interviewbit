package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBst {

    public TreeNode sortedArrayToBST(List<Integer> a) {
        if (a.size() == 0) {
            return null;
        }
        if (a.size() == 1) {
            return new TreeNode(a.get(0));
        }

        int rootId = a.size() / 2;
        TreeNode root = new TreeNode(a.get(rootId));
        root.left = sortedArrayToBST(a.subList(0, rootId));
        root.right = sortedArrayToBST(a.subList(rootId + 1, a.size()));

        return root;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        SortedArrayToBalancedBst ins = new SortedArrayToBalancedBst();
        TreeNode root = ins.sortedArrayToBST(list);
    }
}
