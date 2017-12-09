package Trees;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public TreeNode flatten0(TreeNode a) {
        if (a == null) {
            return null;
        }
        TreeNode linkedList = null;
        TreeNode linkedListRoot = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(a);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            if (linkedList == null) {
                linkedListRoot = new TreeNode(node.val);
                linkedList = linkedListRoot;
            } else {
                linkedList.right = new TreeNode(node.val);
                linkedList = linkedList.right;
            }
            stack.push(node.right);
            stack.push(node.left);
        }

        return linkedListRoot;
    }

    // more interested

    // Attatches the right sub-tree to the rightmost leaf of the left sub-tree
    // Makes the left sub-tree to the right sub-tree

    public TreeNode flatten(TreeNode a) {
        if (a == null) {
            return null;
        }
        TreeNode next = a;

        while (next != null) {
            if (next.left != null) {
                TreeNode mostRight = next.left;
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }
                mostRight.right = next.right;
                next.right = next.left;
                next.left = null;
            }

            next = next.right;
        }

        return a;
    }

    public static void main(String[] args) {

    }
}
