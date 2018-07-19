package Trees;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderAndPreorder {

    // recursion

    public TreeNode buildTree(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return null;
        }
        return buildTreeRecursive(toList(A), toList(B));
    }

    private TreeNode buildTreeRecursive(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) {
            return null;
        }
        int rootVal = preorder.get(0);
        int rootId = inorder.indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeRecursive(preorder.subList(1, rootId + 1), inorder.subList(0, rootId));
        root.right = buildTreeRecursive(preorder.subList(rootId + 1, preorder.size()), inorder.subList(rootId + 1, inorder.size()));
        return root;
    }

    private List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    // without recursion

    public TreeNode buildTree2(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return null;
        }
        return buildTreeWithoutRecursion(toList(A), toList(B));
    }

    private TreeNode buildTreeWithoutRecursion(List<Integer> preorder, List<Integer> inorder) {
        TreeNode root = new TreeNode(preorder.remove(0));
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(root);
        TreeNode newNode = null, temp = null;

        while (preorder.size() > 0 && inorder.size() > 0) {
            boolean rightBranch = false;
            while (arrayList.size() > 0
                    && inorder.get(0) == arrayList.get(arrayList.size() - 1).val) {
                inorder.remove(0);
                temp = arrayList.remove(arrayList.size() - 1);
                rightBranch = true;
            }
            newNode = new TreeNode(preorder.remove(0));
            if (rightBranch) {
                temp.right = newNode;
                arrayList.add(newNode);
            } else {
                arrayList.get(arrayList.size() - 1).left = newNode;
                arrayList.add(newNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] A = new int[5];
        int[] B = new int[5];

        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 5;

        B[0] = 3;
        B[1] = 2;
        B[2] = 4;
        B[3] = 1;
        B[4] = 5;

        BinaryTreeFromInorderAndPreorder instance = new BinaryTreeFromInorderAndPreorder();
        TreeNode tree = instance.buildTree2(A, B);
    }
}
