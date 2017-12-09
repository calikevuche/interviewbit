package Trees;

import java.util.*;

public class BinaryTreeFromInorderAndPostorder {

    // recursion

    public TreeNode buildTree0(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.isEmpty()) {
            return null;
        }
        if (inorder.size() == 1) {
            return new TreeNode(inorder.get(0));
        }
        int lastPostorderId = postorder.size() - 1;
        int lastPostorderVal = postorder.get(lastPostorderId);
        TreeNode root = new TreeNode(lastPostorderVal);
        int inorderRootId = inorder.indexOf(lastPostorderVal);

        List<Integer> leftInor = inorder.subList(0, inorderRootId);
        List<Integer> leftPost = postorder.subList(0, inorderRootId);
        List<Integer> rightInor = inorder.subList(inorderRootId + 1, inorder.size());
        List<Integer> rightPost = postorder.subList(inorderRootId, lastPostorderId);

        root.left = buildTree(leftInor, leftPost);
        root.right = buildTree(rightInor, rightPost);
        return root;
    }

    // without recursion

    public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.isEmpty()) {
            return null;
        }
        TreeNode n;
        TreeNode root;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        root = new TreeNode(postorder.remove(postorder.size() - 1));
        nodes.add(root);

        while (true) {
            if (inorder.get(inorder.size() - 1) == nodes.get(nodes.size() - 1).val) {
                n = nodes.remove(nodes.size() - 1);
                inorder.remove(inorder.size() - 1);
                if (inorder.size() == 0) {
                    break;
                }
                if (nodes.size() != 0 &&
                        inorder.get(inorder.size() - 1) == nodes.get(nodes.size() - 1).val) {
                    continue;
                }
                n.left = new TreeNode(postorder.remove(postorder.size() - 1));
                nodes.add(n.left);
            } else {
                n = new TreeNode(postorder.remove(postorder.size() - 1));
                nodes.get(nodes.size() - 1).right = n;
                nodes.add(n);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInorderAndPostorder instance = new BinaryTreeFromInorderAndPostorder();
        TreeNode tree = instance.buildTree(
                new ArrayList<>(Arrays.asList(4,2,5,1,3,9,7,6,8)),
                new ArrayList<>(Arrays.asList(4,5,2,9,7,8,6,3,1)));
    }
}
