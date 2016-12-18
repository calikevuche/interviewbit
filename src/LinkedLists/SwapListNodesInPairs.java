package LinkedLists;

/**
 * Created by OlehKa on 02.10.2016.
 */
public class SwapListNodesInPairs {

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode nextA = a.next;
        ListNode nextNextA = a.next.next;
        a.next = null;
        nextA.next = a;
        ListNode head = nextA;
        ListNode prevA = a;
        a = nextNextA;

        while (a != null && a.next != null) {
            nextA = a.next;
            nextNextA = a.next.next;
            a.next = null;
            nextA.next = a;
            prevA.next = nextA;
            prevA = a;
            a = nextNextA;
        }

        if (a != null) prevA.next = a;

        return head;
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
