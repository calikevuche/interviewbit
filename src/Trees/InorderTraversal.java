package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InorderTraversal {


    // good
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    // bad
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> intList = new ArrayList<>();
        if (root == null) {
            return intList;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = null;
        int index = 0;
        while (!q.isEmpty()) {
            node = q.poll();
            index = nodeList.indexOf(node);
            if (node.right != null) {
                nodeList.add(index + 1, node.right);
                q.add(node.right);
            }
            if (node.left != null) {
                nodeList.add(index, node.left);
                q.add(node.left);
            }
        }
        for (TreeNode n : nodeList) {
            intList.add(n.val);
        }
        return intList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        InorderTraversal ins = new InorderTraversal();
        ins.inorderTraversal(root);
    }
}
