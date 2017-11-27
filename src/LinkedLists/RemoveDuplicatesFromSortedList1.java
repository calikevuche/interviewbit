package LinkedLists;

/**
 * Created by OlehKa on 22.09.2016.
 */
public class RemoveDuplicatesFromSortedList1 {

    public ListNode deleteDuplicates1(ListNode a) {
        if (a.next == null) return a;
        ListNode unique = null;
        ListNode firstUnique = null;
        while (a.next != null) {
            if (a.val != a.next.val) {
                if (unique == null) {
                    unique = new ListNode(a.val);
                    firstUnique = unique;
                } else {
                    unique.next = new ListNode(a.val);
                    unique = unique.next;
                }
            }
            if (a.next.next == null) {
                if (unique == null) {
                    unique = new ListNode(a.next.val);
                    firstUnique = unique;
                } else {
                    unique.next = new ListNode(a.next.val);
                }
            }
            a = a.next;
        }
        return firstUnique;
    }

    public ListNode deleteDuplicates(ListNode a) {
        ListNode origin = a;
        while (a != null) {
            while (a.next != null && a.val == a.next.val) {
                a.next = a.next.next;
            }
            a = a.next;
        }
        return origin;
    }


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList1 instance = new RemoveDuplicatesFromSortedList1();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
//        ListNode a3 = new ListNode(2);
//        ListNode a4 = new ListNode(3);
//        ListNode a5 = new ListNode(3);
        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;
        instance.deleteDuplicates(a1);

    }
}
