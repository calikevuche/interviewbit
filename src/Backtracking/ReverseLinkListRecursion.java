package Backtracking;

import LinkedLists.ListNode;

/**
 * Created by OlehKa on 31.10.2016.
 */
public class ReverseLinkListRecursion {

    public ListNode reverseList(ListNode a) {
        ListNode head;
        if (a.next == null) {
            head = a;
            return head;
        }
        head = reverseList(a.next);
        ListNode next = a.next;
        next.next = a;
        a.next = null;
        return head;
    }

    public static void main(String[] args) {

    }
}
