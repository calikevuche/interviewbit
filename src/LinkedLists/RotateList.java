package LinkedLists;

public class RotateList {

    public ListNode rotateRight(ListNode A, int B) {
        if (A == null || A.next == null) {
            return A;
        }
        int len = getLength(A);
        int shift = B % len;
        ListNode head = A;
        ListNode tail = getLastNode(A);
        ListNode endNode = A;
        for (int i = 0; i < len - shift - 1; i++) {
            endNode = endNode.next;
        }
        if (endNode.next == null) {
            return A;
        }
        tail.next = head;
        ListNode newHead = endNode.next;
        endNode.next = null;
        return newHead;
    }

    private int getLength(ListNode A) {
        int length = 0;
        ListNode node = A;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private ListNode getLastNode(ListNode A) {
        ListNode node = A;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
