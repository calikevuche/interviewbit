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
        a = a.next;
        counter++;
        while (a != null) {
            int i = 0;
            ListNode b = head;
            while (i < counter) {
                if (b == a) return b;
                b = b.next;
                i++;
            }
            a = a.next;
            counter++;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode a) {
        List<ListNode> nodes = new ArrayList<>();
        while (a != null) {
            for (ListNode node: nodes) {
                if (node == a) return node;
            }
            nodes.add(a);
            a = a.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode a) {
        ListNode head = a;
        ListNode slow = a;
        ListNode fast = a;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = fast.next;
                int size = 1;
                while (fast != slow) {
                    fast = fast.next;
                    size++;
                }
                slow = head;
                fast = head;
                while (size > 0) {
                    fast = fast.next;
                    size--;
                }
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
