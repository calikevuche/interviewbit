package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RecoverBinarySearchTree {

    // wrong solution with recursion :(
    // cause it's NOT inorder traversal

    public int[] recoverTree0(TreeNode A) {
        int[] result = new int[2];
        List<Integer> wrongList = new ArrayList<>();
        List<Integer> minMax = new ArrayList<>();

        findWrong(A, Integer.MIN_VALUE, Integer.MAX_VALUE, wrongList, minMax);
        if (wrongList.size() == 1) {
            wrongList.add(minMax.get(0));
        }
        if (wrongList.size() == 2) {
            Collections.sort(wrongList);
            result[0] = wrongList.get(0);
            result[1] = wrongList.get(1);
        }
        return result;
    }

    private void findWrong(TreeNode root, int min, int max, List<Integer> res, List<Integer> minMax) {
        if (root == null || res.size() == 2) {
            return;
        }
        if (root.val < min) {
            res.add(root.val);
            minMax.add(min);
        }
        if (root.val > max) {
            res.add(root.val);
            minMax.add(max);
        }
        findWrong(root.left, min, root.val, res, minMax);
        findWrong(root.right, root.val, max, res, minMax);
    }

    // O(N) time, O(depth) space
    // https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/

    public int[] recoverTree1(TreeNode A) {
        int[] result = new int[2];
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = A, prev = null;
        TreeNode first = null, second = null, prevFirst = null;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            if (prev != null && prev.val > cur.val) {
                if (first == null) {
                    first = cur;
                    prevFirst = prev;
                } else if (second == null) {
                    second = cur;
                }
            }

            prev = cur;
            cur = cur.right;
        }
        if (prevFirst != null) {
            result[0] = second != null ? second.val : first.val;
            result[1] = prevFirst.val;
        }
        return result;
    }

    // O(N) time, O(1) space (Morris Traversal)
    // https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/

    public int[] recoverTree2(TreeNode A) {
        int[] result = new int[2];
        TreeNode cur = A, prev = null, rightMost = null;
        TreeNode first = null, second = null, prevFirst = null;

        while (cur != null) {
            if (cur.left == null) {

                if (prev != null && prev.val > cur.val) {
                    if (first == null) {
                        first = cur;
                        prevFirst = prev;
                    } else {
                        second = cur;
                        break;
                    }
                }

                prev = cur;
                cur = cur.right;
            } else {
                rightMost = cur.left;
                while (rightMost.right != null && rightMost.right != cur) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    // create thread
                    rightMost.right = cur;
                    cur = cur.left;
                } else {
                    // restore original
                    rightMost.right = null;

                    if (prev != null && prev.val > cur.val) {
                        if (first == null) {
                            first = cur;
                            prevFirst = prev;
                        } else {
                            second = cur;
                            break;
                        }
                    }

                    prev = cur;
                    cur = cur.right;
                }
            }
        }

        if (prevFirst != null) {
            result[0] = second != null ? second.val : first.val;
            result[1] = prevFirst.val;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);

        RecoverBinarySearchTree ins = new RecoverBinarySearchTree();
        ins.recoverTree0(root);
    }
}
