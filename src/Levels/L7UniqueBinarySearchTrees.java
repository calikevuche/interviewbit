package Levels;

import Trees.TreeNode;

import java.util.ArrayList;

public class L7UniqueBinarySearchTrees {

    public ArrayList<TreeNode> generateTrees(int A) {
        ArrayList<TreeNode> trees = new ArrayList<>();
        generateSubtrees(1, A, trees);
        return trees;
    }

    private void generateSubtrees(int start, int end, ArrayList<TreeNode> trees) {
        if (start > end) {
            return;
        } else if (start == end) {
            trees.add(new TreeNode(start));
        }
        for (int i = start; i < end + 1; i++) {
            ArrayList<TreeNode> left = new ArrayList<>();
            ArrayList<TreeNode> right = new ArrayList<>();
            generateSubtrees(start, i - 1, left);
            generateSubtrees(i + 1, end, right);
            if (left.size() > 0 && right.size() > 0) {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        trees.add(root);
                    }
                }
            } else if (left.size() == 0) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    trees.add(root);
                }
            } else {
                for (TreeNode l : left) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    trees.add(root);
                }
            }
        }
    }

    public static void main(String[] args) {
        L7UniqueBinarySearchTrees instance = new L7UniqueBinarySearchTrees();
        System.out.println(instance.generateTrees(3));
    }
}