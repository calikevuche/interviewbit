package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (ListNode node : a) {
            priorityQueue.add(node.val);
        }
        ListNode result = new ListNode(priorityQueue.poll());
        ListNode headResult = result;
        boolean finish = false;
        ListNode node;
        while (!finish) {
            finish = true;
            for (int i = 0; i < a.size(); i++) {
                node = a.get(i);
                if (node == null) {
                    continue;
                }
                finish = false;
                if (node.val == result.val) {
                    node = node.next;
                    a.set(i, node);
                    if (node != null) {
                        priorityQueue.add(node.val);
                    }
                    break;
                }
            }
            if (!priorityQueue.isEmpty()) {
                result.next = new ListNode(priorityQueue.poll());
                result = result.next;
            }
        }
        return headResult;
    }

    public ListNode mergeKLists2(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        priorityQueue.addAll(a);
        ListNode temp = null;
        ListNode result = null;
        ListNode headResult = null;
        while (!priorityQueue.isEmpty()) {
            temp = priorityQueue.poll();
            if (result == null) {
                result = new ListNode(temp.val);
                headResult = result;
            } else {
                result.next = new ListNode(temp.val);
                result = result.next;
            }
            if (temp.next != null) {
                temp = temp.next;
                priorityQueue.add(temp);
            }
        }
        return headResult;
    }

    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(10);
        n1.next.next = new ListNode(20);
        ListNode n2 = new ListNode(4);
        n2.next = new ListNode(11);
        n2.next.next = new ListNode(13);
        ListNode n3 = new ListNode(3);
        n3.next = new ListNode(8);
        n3.next.next = new ListNode(9);
        ArrayList<ListNode> arrayList = new ArrayList<>();
        arrayList.add(n1);
        arrayList.add(n2);
        arrayList.add(n3);
        obj.mergeKLists2(arrayList);
    }
}

//Definition for singly-linked list.
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}