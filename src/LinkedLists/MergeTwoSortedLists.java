package LinkedLists;

/**
 * Created by OlehKa on 22.09.2016.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists1(ListNode a, ListNode b) {
        ListNode first = null;
        ListNode merge = null;
        while (a != null && b != null) {
            int val = Math.min(a.val, b.val);
            if (merge == null) {
                merge = new ListNode(val);
                first = merge;
            } else {
                merge.next = new ListNode(val);
                merge = merge.next;
            }
            if (val == a.val) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        if (a != null) {
            if (merge == null) {
                merge = a;
                first = merge;
            } else {
                merge.next = a;
            }
        } else if (b != null) {
            if (merge == null) {
                merge = b;
                first = merge;
            } else {
                merge.next = b;
            }
        }
        return first;
    }

    public ListNode mergeTwoLists2(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head = new ListNode(0);
        ListNode merge = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                merge.next = a;
                a = a.next;
            } else {
                merge.next = b;
                b = b.next;
            }
            merge = merge.next;
        }
        if (a != null) {
            merge.next = a;
        } else {
            merge.next = b;
        }
        return head.next;
    }
}
