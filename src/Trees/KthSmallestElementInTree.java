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
            while (node.left != null) {
                node = node.left;
                stack.push(node);
            }
            node = stack.pop();
            arrayList.add(node.val);
//            node.left = null;

            while (!stack.isEmpty() && node.right == null) {
                node = stack.pop();
                arrayList.add(node.val);
                node.left = null;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return arrayList.get(k - 1);
    }

    // optimized

    public int kthsmallest1(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while (node.left != null) {
                node = node.left;
                stack.push(node);
            }
            node = stack.pop();
            if (k == 1) {
                return node.val;
            } else {
                k--;
            }

            while (!stack.isEmpty() && node.right == null) {
                node = stack.pop();
                node.left = null;
                if (k == 1) {
                    return node.val;
                } else {
                    k--;
                }
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return 0;
    }

    // recursive

    class Counter {
        int val;

        Counter(int val) {
            this.val = val;
        }
    }

    public int kthsmallest2(TreeNode root, int k) {
        return kthsmallestInternal(root, new Counter(k));
    }

    private int kthsmallestInternal(TreeNode root, Counter counter) {
        if (root == null) {
            return 0;
        }
        int left = kthsmallestInternal(root.left, counter);
        if (counter.val == 0) {
            return left;
        }
        counter.val--;
        if (counter.val == 0) {
            return root.val;
        }
        return kthsmallestInternal(root.right, counter);
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
        int res = ins.kthsmallest2(node1, 3);
    }
}
