package LinkedLists;

/**
 * Created by OlehKa on 20.09.2016.
 */
public class PalindromeList {

    public int lPalin(ListNode A) {
        ListNode firstE = A;
        int lenA = getLength(A);
        int middleE = (lenA % 2 == 0) ? lenA / 2 + 1 : lenA / 2 + 2;
        int counter = 0;
        while (counter < middleE - 1) {
            A = A.next;
            counter++;
        }
        ListNode next, prev = null;
        while (A != null) {
            next = A.next;
            A.next = prev;
            prev = A;
            A = next;
        }
        while (firstE != null && prev != null) {
            if (firstE.val != prev.val) return 0;
            firstE = firstE.next;
            prev = prev.next;
        }
        return 1;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    // ***************************************************

    private ListNode reverse(ListNode a) {
        ListNode head = null, next = null;
        while (a != null) {
            next = a.next;
            a.next = head;
            head = a;
            a = next;
        }
        return head;
    }

    private int compare(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) {
                return 0;
            }
            a = a.next;
            b = b.next;
        }
        return (a == null && b == null) ? 1 : 0;
    }

    public int lPalin2(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        ListNode slow = A, fast = A, lastFirstHalf = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            lastFirstHalf = slow;
            slow = slow.next;
        }
        ListNode middle = null;
        if (fast != null) {
            middle = slow;
            slow = slow.next;
        }
        ListNode secondHalf = slow;
        secondHalf = reverse(secondHalf);
        lastFirstHalf.next = null;
        int result = compare(A, secondHalf);
        secondHalf = reverse(secondHalf);
        if (middle != null) {
            lastFirstHalf.next = middle;
            middle.next = secondHalf;
        } else {
            lastFirstHalf.next = secondHalf;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        PalindromeList palindromeList = new PalindromeList();
        System.out.println(palindromeList.lPalin(a1));
    }
}
