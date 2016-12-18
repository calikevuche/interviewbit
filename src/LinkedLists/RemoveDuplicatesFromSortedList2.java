package LinkedLists;

import TwoPointers.RemoveDuplicatesFromSortedArray;

/**
 * Created by OlehKa on 21.09.2016.
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode a) {
        if (a.next == null) return a;
        ListNode unique = null;
        ListNode firstUnique = null;
        if (a.val != a.next.val) {
            unique = new ListNode(a.val);
            firstUnique = unique;
        }
        ListNode prev = a;
        a = a.next;
        while (a.next != null) {
            if (prev.val != a.val && a.val != a.next.val) {
                if (unique == null) {
                    unique = new ListNode(a.val);
                    firstUnique = unique;
                }
                else {
                    unique.next = new ListNode(a.val);
                    unique = unique.next;
                }
            }
            prev = a;
            a = a.next;
        }
        if (prev.val != a.val) {
            if (unique == null) {
                unique = a;
                firstUnique = unique;
            }
            else unique.next = a;
        }
        return firstUnique;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 instance = new RemoveDuplicatesFromSortedList2();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);
//        ListNode a4 = new ListNode(3);
//        ListNode a5 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;
        instance.deleteDuplicates(a1);
    }
}
