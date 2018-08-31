package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestMultipleWith0And1 {

    public String multiple(int A) {
        if (A < 0) {
            return multiple(-A);
        }
        if (A == 0 || A == 1) {
            return String.valueOf(A);
        }
//        HashSet<Integer> reminders = new HashSet<>(); => Time Limit Exception
        boolean[] visited = new boolean[A];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(null, 1, 1));

        while (true) { // result always exists!
            Node head = queue.remove();
            int rem = head.value % A;
            if (rem == 0) {
                return getResult(head);
            } else {
                if (!visited[rem]) {
                    visited[rem] = true;
                    Node n0 = new Node(head, rem * 10, 0);
                    Node n1 = new Node(head, rem * 10 + 1, 1);
                    queue.add(n0);
                    queue.add(n1);
                }
            }
        }
    }

    private String getResult(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.digit);
            node = node.parent;
        }
        return stringBuilder.reverse().toString();
    }

    class Node {
        Node parent;
        int value;
        int digit;

        Node(Node parent, int value, int digit) {
            this.parent = parent;
            this.value = value;
            this.digit = digit;
        }
    }

    public static void main(String[] args) {
        SmallestMultipleWith0And1 instance = new SmallestMultipleWith0And1();
        instance.multiple(7);
    }
}
