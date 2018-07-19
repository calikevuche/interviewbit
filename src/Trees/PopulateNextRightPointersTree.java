package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersTree {

    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue1 = new LinkedList<>();
        Queue<TreeLinkNode> queue2 = new LinkedList<>();
        Queue<TreeLinkNode> temp = null;
        queue1.add(root);

        while (!queue1.isEmpty()) {

            while (!queue1.isEmpty()) {
                TreeLinkNode current = queue1.poll();
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
        }
    }

    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        //we update the tree row by row (elements at same depth)
        //first while loop iterates across rows and second iterates within a row
        //firstNode points to first child of next row to be processed
        TreeLinkNode firstNode = root;

        while (firstNode != null) {
            TreeLinkNode cur = firstNode;
            firstNode = null;

            //we use prevUpd to keep track of last node in a row whose next has NOT been updated
            TreeLinkNode prevUpd = null;

            while (cur != null) {
                if (cur.left != null) {
                    if (firstNode == null) {
                        firstNode = cur.left;
                    }
                    if (prevUpd != null) {
                        prevUpd.next = cur.left;
                    }
                    prevUpd = cur.left;
                }
                if (cur.right != null) {
                    if (firstNode == null) {
                        firstNode = cur.right;
                    }
                    if (prevUpd != null) {
                        prevUpd.next = cur.right;
                    }
                    prevUpd = cur.right;
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
