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
        ListNode next;
        ListNode prev = null;
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

    public int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
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
