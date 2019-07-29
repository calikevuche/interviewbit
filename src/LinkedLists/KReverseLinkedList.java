package LinkedLists;

public class KReverseLinkedList {

    public ListNode reverseList(ListNode A, int B) {
        int len = getLength(A);
        int size = len / B;
        ListNode resultHead = null;
        ListNode node, curStart = A, nextStart = null, prevEnd = null, reverse = null;
        for (int i = 0; i < size; i++) {
            node = curStart;
            for (int j = 0; j < B - 1; j++) {
                node = node.next;
            }
            nextStart = node.next;
            node.next = null;
            reverse = reverseList(curStart);
            if (resultHead == null) {
                resultHead = reverse;
            }
            if (prevEnd != null) {
                prevEnd.next = reverse;
            }
            prevEnd = curStart;
            curStart = nextStart;
        }
        return resultHead;
    }

    public ListNode reverseList(ListNode A) {
        ListNode prevNode = null;
        ListNode curNode = A;
        ListNode nextNode = A.next;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }

    public void printNodes(ListNode A) {
        while (A != null) {
            System.out.print(A.val + " ");
            A = A.next;
        }
        System.out.println("OK");
    }

    private int getLength(ListNode A) {
        int length = 0;
        ListNode node = A;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        KReverseLinkedList ins = new KReverseLinkedList();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        ins.printNodes(n1);
        ins.printNodes(ins.reverseList(n1, 2));
    }
}
