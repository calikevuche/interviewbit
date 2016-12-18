package LinkedLists;

/**
 * Created by OlehKa on 28.09.2016.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode a) {
        ListNode sorted = new ListNode(a.val);
        a = a.next;

        while (a != null) {
            ListNode iterator = sorted;
            if (a.val < iterator.val) {
                ListNode start = new ListNode(a.val);
                start.next = sorted;
                sorted = start;
            } else {
                while (iterator.next != null && iterator.next.val < a.val) {
                    iterator = iterator.next;
                }
                ListNode tmpNext = iterator.next;
                iterator.next = new ListNode(a.val);
                iterator.next.next = tmpNext;
            }
            a = a.next;
        }

        return sorted;
    }

    public static void main(String[] args) {

    }
}
