package LinkedLists;

/**
 * Created by OlehKa on 09.09.2016.
 */
public class IntersectionOfLinkedLists {

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int lenA = getLength(a);
        int lenB = getLength(b);
        if (lenA < lenB) return getIntersectionNode(b, a);
        int diff = lenA - lenB;
        for (int i = 0; i < diff; i++) {
            a = a.next;
        }
        for (int i = 0; i < lenB; i++) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }

        return null;
    }

    public int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
    }
}
