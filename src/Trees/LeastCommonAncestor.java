package Trees;

import java.util.*;

public class LeastCommonAncestor {

    public int lca0(TreeNode A, int B, int C) {
        if (A == null) {
            return -1;
        }
        Map<TreeNode, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        map.put(A, new ArrayList<>(Collections.singletonList(A.val)));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

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

        TreeNode k1 = null, k2 = null;
        for (TreeNode key: map.keySet()) {
            if (key.val == B) {
                k1 = key;
            }
            if (key.val == C) {
                k2 = key;
            }
        }
        if (k1 == null || k2 == null) {
            return -1;
        }

        ArrayList<Integer> arrayList1 = map.get(k1);
        ArrayList<Integer> arrayList2 = map.get(k2);
        arrayList1.retainAll(arrayList2);
        return arrayList1.get(arrayList1.size() - 1);
    }

    // recursion
    public int lca(TreeNode A, int B, int C) {
        if (A == null || !find(A, B) || !find(A, C)) {
            return -1;
        }
        TreeNode result = lcaRecursive(A, B, C);
        return result == null ? -1 : result.val;
    }

    private TreeNode lcaRecursive(TreeNode A, int B, int C) {
        if (A == null) {
            return null;
        }
        if (A.val == B || A.val == C) {
            return A;
        }
        TreeNode left = lcaRecursive(A.left, B, C);
        TreeNode right = lcaRecursive(A.right, B, C);
        if (left != null && right != null) {
            return A;
        }
        return left != null ? left : right;
    }

    private boolean find(TreeNode A, int B) {
        if (A == null) {
            return false;
        }
        if (A.val == B) {
            return true;
        }
        boolean left = find(A.left, B);
        boolean right = find(A.right, B);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);

        node.left = new TreeNode(5);
        node.right = new TreeNode(1);

        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);

        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);

        LeastCommonAncestor instance = new LeastCommonAncestor();
        System.out.println(instance.lca(node, 5 ,5 ));
    }
}
