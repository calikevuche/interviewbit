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
                    left = new ListNode(a.val);
                    firstLeft = left;
                } else {
                    left.next = new ListNode(a.val);
                    left = left.next;
                }
            } else {
                if (firstRight == null) {
                    right = new ListNode(a.val);
                    firstRight = right;
                } else {
                    right.next = new ListNode(a.val);
                    right = right.next;
                }
            }
            a = a.next;
        }
        if (left != null && right != null) {
            left.next = firstRight;
        } else if (left == null && right != null) {
            firstLeft = firstRight;
        }
        return firstLeft;
    }

    public static void main(String[] args) {

    }
}
