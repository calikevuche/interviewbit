package LinkedLists;

/**
 * Created by OlehKa on 03.10.2016.
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode result = null;
        ListNode next = null;
        ListNode prev = null;
        ListNode startRev = null;
        ListNode endRev = null;
        int i = 0;
        if (m > 1) result = a;
        while (i < m-1) {
            if (i == m-2) startRev = a;
            a = a.next;
            i++;
        }
        while (i < n) {
            if (i == m-1) endRev = a;
            next = a.next;
            a.next = prev;
            prev = a;
            a = next;
            i++;
        }
        if (m == 1) result = prev;
        else startRev.next = prev;
        if (a != null && endRev != null) endRev.next = a;
        return result;
    }

    public static void main(String[] args) {

    }
}
