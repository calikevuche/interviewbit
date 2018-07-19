package Trees;

import java.util.*;

public class BinaryTreeFromInorderAndPostorder {

    // recursion

    public TreeNode buildTree1(List<Integer> inorder, List<Integer> postorder) {
        if (inorder == null || postorder == null || inorder.isEmpty() || postorder.isEmpty()) {
            return null;
        }
        if (inorder.size() == 1) {
            return new TreeNode(inorder.get(0));
        }
        int lastPostorderId = postorder.size() - 1;
        int lastPostorderVal = postorder.get(lastPostorderId);
        int inorderRootId = inorder.indexOf(lastPostorderVal);

        List<Integer> leftInorder = inorder.subList(0, inorderRootId);
        List<Integer> leftPostorder = postorder.subList(0, inorderRootId);
        List<Integer> rightInorder = inorder.subList(inorderRootId + 1, inorder.size());
        List<Integer> rightPostorder = postorder.subList(inorderRootId, lastPostorderId);

        TreeNode root = new TreeNode(lastPostorderVal);
        root.left = buildTree1(leftInorder, leftPostorder);
        root.right = buildTree1(rightInorder, rightPostorder);
        return root;
    }

    // without recursion

    public TreeNode buildTree2(List<Integer> inorder, List<Integer> postorder) {
        if (inorder == null || postorder == null || inorder.isEmpty() || postorder.isEmpty()) {
            return null;
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        TreeNode root = new TreeNode(postorder.remove(postorder.size() - 1));
        nodes.add(root);
        TreeNode temp = null, newNode = null;

        while (inorder.size() > 0 && postorder.size() > 0) {
            boolean leftBranch = false;
            while (nodes.size() > 0 &&
                    inorder.get(inorder.size() - 1) == nodes.get(nodes.size() - 1).val) {
                inorder.remove(inorder.size() - 1);
                temp = nodes.remove(nodes.size() - 1);
                leftBranch = true;
            }
            newNode = new TreeNode(postorder.remove(postorder.size() - 1));
            if (leftBranch) {
                temp.left = newNode;
                nodes.add(newNode);
            } else {
                nodes.get(nodes.size() - 1).right = newNode;
                nodes.add(newNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInorderAndPostorder instance = new BinaryTreeFromInorderAndPostorder();
        TreeNode tree = instance.buildTree2(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                new ArrayList<>(Arrays.asList(1, 3, 2, 5, 7, 6, 4))
        );
    }
}
