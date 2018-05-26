package LinkedLists;

/**
 * Created by OlehKa on 09.09.2016.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode a) {
        ListNode current = a;
        ListNode next;
        ListNode head = null;
        while (current != null) {
            next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
        return head;
    }
}
