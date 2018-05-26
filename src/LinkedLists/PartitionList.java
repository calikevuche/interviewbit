package LinkedLists;

/**
 * Created by OlehKa on 27.09.2016.
 */
public class PartitionList {

    public ListNode partition(ListNode a, int b) {
        ListNode left = null, right = null;
        ListNode firstLeft = null, firstRight = null;
        while (a != null) {
            if (a.val < b) {
                if (firstLeft == null) {
                    firstLeft = a;
                    left = firstLeft;
                } else {
                    left.next = a;
                    left = left.next;
                }
            } else {
                if (firstRight == null) {
                    firstRight = a;
                    right = firstRight;
                } else {
                    right.next = a;
                    right = right.next;
                }
            }
            a = a.next;
        }
        if (left != null) {
            left.next = firstRight;
        } else {
            firstLeft = firstRight;
        }
        if (right != null) {
            right.next = null;
        }
        return firstLeft;
    }

    public static void main(String[] args) {

    }
}
