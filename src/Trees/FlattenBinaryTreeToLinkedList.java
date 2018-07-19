package Trees;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    // NOT in-place
    public TreeNode flatten0(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode linkedList = null;
        TreeNode linkedListRoot = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);

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

    // preorder traversal
    public TreeNode flatten1(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode node = A;

        while (node != null) {
            if (node.left != null) {
                TreeNode mostRight = node.left;
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }
                mostRight.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
        return A;
    }
}
