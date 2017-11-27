package Levels;

import LinkedLists.ListNode;

/**
 * Created by OlehKa on 30.10.2016.
 */
public class L4Subtract {

    public ListNode subtract(ListNode a) {
        int length = getLength(a);
        if (length < 2) return a;
        int halfSize = length / 2;

        ListNode current = copy(a);
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode result = a;
        for (int i = 0; i < halfSize; i++) {
            int valA = a.val;
            int valPrev = prev.val;
            a.val = valPrev - valA;
            a = a.next;
            prev = prev.next;
        }

        return result;
    }

    public int getLength(ListNode a) {
        int length = 0;
        while (a != null) {
            a = a.next;
            length++;
        }
        return length;
    }

    public ListNode copy(ListNode a) {
        ListNode copy = new ListNode(a.val);
        ListNode result = copy;
        while (a.next != null) {
            a = a.next;
            copy.next = new ListNode(a.val);
            copy = copy.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        L4Subtract instance = new L4Subtract();
        instance.subtract(a1);
    }
}
