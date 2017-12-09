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
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        arrayList.add(root);
        int index = arrayList.indexOf(root);
        if (root.right != null) arrayList.add(index + 1, root.right);
        if (root.left != null) arrayList.add(index, root.left);
        q.add(root.left);
        q.add(root.right);
        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node == null) {
                continue;
            }
            index = arrayList.indexOf(node);
            if (node.right != null) arrayList.add(index + 1, node.right);
            if (node.left != null) arrayList.add(index, node.left);
            q.add(node.left);
            q.add(node.right);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (TreeNode treeNode : arrayList) {
            result.add(treeNode.val);
        }
        return result;
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
