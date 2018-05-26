package LinkedLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OlehKa on 23.09.2016.
 */
public class ListCycle {

    public ListNode detectCycle1(ListNode a) {
        int counter = 0;
        ListNode head = a;
        while (a != null) {
            int i = 0;
            ListNode b = head;
            while (i < counter) {
                if (b == a) {
                    return b;
                }
                b = b.next;
                i++;
            }
            a = a.next;
            counter++;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = a;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
