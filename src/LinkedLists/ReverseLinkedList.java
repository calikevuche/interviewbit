package LinkedLists;

/**
 * Created by OlehKa on 09.09.2016.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode a) {
        ListNode current = a;
        ListNode next;
        ListNode prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
