package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInTree {

    public int kthsmallest0(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                continue;
            }
            while (node.left != null) {
                node = node.left;
                stack.push(node);
            }
            node = stack.pop();
            arrayList.add(node.val);
            node.left = null;

            while (!stack.isEmpty() &&
                    node.right == null) {
                node = stack.pop();
                arrayList.add(node.val);
                node.left = null;
            }

            stack.push(node.right);
        }

        return arrayList.get(k - 1);
    }

    // optimized

    public int kthsmallest1(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            arrayList.add(node.val);
            if (arrayList.size() == k) {
                return arrayList.get(arrayList.size() - 1);
            }
            node = node.right;
        }

        return 0;
    }

    // recursive

    int counter;

    public int kthsmallest(TreeNode root, int k) {
        counter = k;
        return kthsmallestInternal(root);
    }

    private int kthsmallestInternal(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int k1 = kthsmallestInternal(root.left);
        if (counter == 0) return k1;
        counter--;
        if (counter == 0) return root.val;

        return kthsmallestInternal(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        node1.left = new TreeNode(5);
        node1.right = new TreeNode(20);

        node1.left.left = new TreeNode(3);
        node1.left.left.left = new TreeNode(1);
        node1.left.left.right = new TreeNode(4);

        node1.left.right = new TreeNode(6);
        node1.left.right.right = new TreeNode(8);



        TreeNode node2 = new TreeNode(3);
        node2.right = new TreeNode(4);

        KthSmallestElementInTree ins = new KthSmallestElementInTree();
        int res = ins.kthsmallest(node1, 3);
    }
}
