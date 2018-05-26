package LinkedLists;

/**
 * Created by OlehKa on 03.10.2016.
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode a, int m, int n) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode current = a;
        ListNode head = current;
        ListNode prefixEnd = null;
        int i = 1;
        while (i < m) {
            if (i == m - 1) {
                prefixEnd = current;
            }
            current = current.next;
            i++;
        }
        ListNode reverseEnd = current;
        ListNode next = null;
        ListNode prev = null;
        while (i <= n) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        if (prefixEnd != null) {
            prefixEnd.next = prev;
        } else {
            head = prev;
        }
        if (reverseEnd != null) {
            reverseEnd.next = current;
        }
        return head;
    }
}
