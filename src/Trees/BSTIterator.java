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

    /** @return whether we have a next smallest number */

    public boolean hasNext() {
        return !stackNext.isEmpty() || next != null;
    }

    /** @return the next smallest number */

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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);

        node1.left = new TreeNode(5);
        node1.right = new TreeNode(20);

        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(6);

        BSTIterator iterator = new BSTIterator(node1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
