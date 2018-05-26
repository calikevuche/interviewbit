package LinkedLists;

/**
 * Created by OlehKa on 02.10.2016.
 */
public class SwapListNodesInPairs {

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode head = new ListNode(0);
        ListNode cur = a;
        ListNode next, nextNext, prev = head;
        while (cur != null && cur.next != null) {
            next = cur.next;
            nextNext = cur.next.next;
            next.next = cur;
            cur.next = null;
            prev.next = next;
            prev = cur;
            cur = nextNext;
        }
        if (cur != null) {
            prev.next = cur;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(27);
        ListNode n2 = new ListNode(67);
        ListNode n3 = new ListNode(10);
        ListNode n4 = new ListNode(64);
        ListNode n5 = new ListNode(85);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(16);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        SwapListNodesInPairs swapListNodesInPairs = new SwapListNodesInPairs();
        swapListNodesInPairs.swapPairs(n1);
    }
}
