package LinkedLists;

public class ReorderList {

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null || A.next.next == null) {
            return A;
        }
        ListNode fast = A, slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode n1 = A, n2 = reverse(slow), next1, next2;
        while (n1 != null && n2 != null) {
            next1 = n1.next;
            next2 = n2.next;
            n1.next = n2;
            n2.next = next1;
            n1 = next1;
            n2 = next2;
        }
        if (n1 != null) {
            n1.next = null;
        }
        return A;
    }

    private ListNode reverse(ListNode n) {
        ListNode next = null, prev = null;
        while (n != null) {
            next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }
        return prev;
    }
}
