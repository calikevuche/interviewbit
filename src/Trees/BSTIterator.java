package Trees;

import java.util.Stack;

public class BSTIterator {

    private TreeNode next = null;
    private TreeNode prev = null;

    private Stack<TreeNode> stackNext = new Stack<>();
    private Stack<TreeNode> stackPrev = new Stack<>();

    public BSTIterator(TreeNode root) {
        next = prev = root;
    }

    public boolean hasNext() {
        return !stackNext.isEmpty() || next != null;
    }

    public int next() {
        while (next != null) {
            stackNext.push(next);
            next = next.left;
        }
        TreeNode temp = stackNext.pop();
        next = temp.right;
        return temp.val;
    }

    public boolean hasPrev() {
        return !stackPrev.isEmpty() || prev != null;
    }

    public int prev() {
        while (prev != null) {
            stackPrev.push(prev);
            prev = prev.right;
        }
        TreeNode temp = stackPrev.pop();
        prev = temp.left;
        return temp.val;
    }
}
