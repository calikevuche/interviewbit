package Graphs;

import LinkedLists.ListNode;
import Trees.TreeNode;

public class ConvertSortedListToBST {

    public ListNode listNode = null;

    public TreeNode sortedListToBSTv1(ListNode listNode) {
        int size = getSize(listNode);
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return new TreeNode(listNode.val);
        }
        ListNode prev = getElement(listNode, size / 2 - 1);
        ListNode next = prev.next;
        prev.next = null;
        TreeNode treeNode = new TreeNode(next.val);
        treeNode.left = sortedListToBSTv1(listNode);
        treeNode.right = sortedListToBSTv1(next.next);
        return treeNode;
    }

    public TreeNode sortedListToBSTv2(ListNode listNode) {
        this.listNode = listNode;
        return sortedListToBST(getSize(listNode));
    }

    private TreeNode sortedListToBST(int size) {
        if (size == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = sortedListToBST(size / 2);
        treeNode.val = listNode.val;
        this.listNode = listNode.next;
        treeNode.right = sortedListToBST(size - size / 2 - 1);
        return treeNode;
    }

    private int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    private ListNode getElement(ListNode node, int index) {
        if (node == null) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedListToBST ins = new ConvertSortedListToBST();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        TreeNode t = ins.sortedListToBSTv2(n1);
    }
}
