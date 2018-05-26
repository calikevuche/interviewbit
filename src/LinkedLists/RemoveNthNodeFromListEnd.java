package LinkedLists;

public class RemoveNthNodeFromListEnd {

    public ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null || B <= 0) {
            return A;
        }
        ListNode fake = new ListNode(0);
        fake.next = A;
        ListNode prev = fake, n1 = A, n2 = A;
        for (int i = 0; i < B; i++) {
            n1 = n1.next;
            if (n1 == null) {
                break;
            }
        }
        while (n1 != null) {
            prev = n2;
            n2 = n2.next;
            n1 = n1.next;
        }
        prev.next = n2.next;
        return fake.next;
    }
}
