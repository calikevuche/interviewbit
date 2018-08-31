package Graphs;

import LinkedLists.ListNode;

public class SumOfFibonacciNumbers {

    public int fibsum(int A) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        generateFibList(head, head.next, A);
        int x = A, n = 0;
        while (x != 0) {
            x -= getFib(head, x);
            n++;
        }
        return n;
    }

    private void generateFibList(ListNode prev, ListNode cur, int max) {
        int sum = prev.val + cur.val;
        while (sum <= max) {
            cur.next = new ListNode(sum);
            prev = cur;
            cur = cur.next;
            sum = prev.val + cur.val;
        }
    }

    private int getFib(ListNode listNode, int max) {
        int fib = 0;
        while (listNode != null && listNode.val <= max) {
            fib = listNode.val;
            listNode = listNode.next;
        }
        return fib;
    }

    public static void main(String[] args) {
        SumOfFibonacciNumbers ins = new SumOfFibonacciNumbers();
        ins.fibsum(2);
    }
}
