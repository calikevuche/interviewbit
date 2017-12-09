package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersTree {

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue1 = new LinkedList<>();
        Queue<TreeLinkNode> queue2 = new LinkedList<>();
        Queue<TreeLinkNode> temp;
        queue1.add(root);

        while (!queue1.isEmpty()) {

            while (!queue1.isEmpty()) {
                TreeLinkNode current = queue1.poll();
                if (current == null) {
                    continue;
                }
                TreeLinkNode next = queue1.peek();
                if (next != null) {
                    current.next = next;
                }
                if (current.left != null) {
                    queue2.add(current.left);
                }
                if (current.right != null) {
                    queue2.add(current.right);
                }
            }

            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            queue2.clear();
        }
    }

    public void connect2(TreeLinkNode root) {
        if(root==null)
            return;

        //we update the tree row by row (elements at same depth)
        //first while loop iterates across rows and second iterates within a row
        //p points to first child of next row to be processed

        TreeLinkNode p = root;

        while (p != null) {
            TreeLinkNode cur = p;
            p = null;
            //we use prevUpd to keep track of last node in a row whose next has NOT been updated
            TreeLinkNode prevUpd = null;
            //update entire row
            while (cur != null) {
                if (cur.left != null) {
                    //if this is the first child in this row
                    if (p == null)
                        p = cur.left;
                    if (prevUpd != null) {
                        prevUpd.next = cur.left;
                    }
                    prevUpd = cur.left;
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                        prevUpd = cur.right;
                    }
                } else {
                    if (cur.right != null) {
                        //if this is the first child in this row
                        if (p == null)
                            p = cur.right;
                        if (prevUpd != null)
                            prevUpd.next = cur.right;
                        prevUpd = cur.right;
                    }
                }
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        PopulateNextRightPointersTree instance = new PopulateNextRightPointersTree();
        instance.connect2(root);
    }
}
