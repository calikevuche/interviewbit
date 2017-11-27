package LinkedLists;

/**
 * Created by OlehKa on 29.09.2016.
 */
public class SortList {

    public ListNode sortList(ListNode a) {
        if (a == null) return null;
        if (a.next == null) return a;
        int len = getLength(a);
        ListNode left = a;
        for (int i = 0; i < len / 2 - 1; i++) {
            a = a.next;
        }
        ListNode right = a.next;
        a.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = null;
        ListNode start = null;
        if (left.val < right.val) {
            result = new ListNode(left.val);
            left = left.next;
        } else {
            result = new ListNode(right.val);
            right = right.next;
        }
        start = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                result.next = new ListNode(left.val);
                left = left.next;
            } else {
                result.next = new ListNode(right.val);
                right = right.next;
            }
            result = result.next;
        }
        if (left != null) {
            result.next = left;
        } else {
            result.next = right;
        }
        return start;
    }

    public int getLength(ListNode a) {
        int length = 0;
        while (a != null) {
            a = a.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {

    }
}
