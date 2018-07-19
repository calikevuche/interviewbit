package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrderOfPeopleHeights {

    // 0(N^2) time
    public int[] order0(int[] A, int[] B) {
        int[] res = new int[A.length];
        int[] visited = new int[A.length];
        int minId = -1;
        for (int i = 0; i < A.length; i++) {
            minId = getMinIndex(A, minId);
            int emptySpaces = B[minId];
            for (int j = 0; j < visited.length; j++) {
                if (visited[j] == 1) {
                    continue;
                }
                if (emptySpaces == 0) {
                    res[j] = A[minId];
                    visited[j] = 1;
                    break;
                }
                emptySpaces--;
            }
        }
        return res;
    }

    private int getMinIndex(int[] arr, int prevId) {
        int prev = prevId < 0 ? Integer.MIN_VALUE : arr[prevId];
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && arr[i] > prev) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    //segment tree
    //https://stackoverflow.com/questions/19174796/puzzle-find-the-order-of-n-persons-standing-in-a-line-based-on-their-heights

    public int[] order1(int[] heights, int[] frontCounts) {
        Person[] persons = new Person[heights.length];

        for (int i = 0; i < persons.length; i++)
            persons[i] = new Person(heights[i], frontCounts[i]);

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p2.height, p1.height);
            }
        });

        Node root = new Node(persons[0]);

        for (int i = 1; i < persons.length; i++) {
            insert(root, persons[i]);
        }

        List<Integer> arrayList = new ArrayList<>();
        traverseInorder(root, arrayList);

        int[] result = new int[heights.length];
        if (result.length == arrayList.size()) {
            for (int i = 0; i < result.length; i++) {
                result[i] = arrayList.get(i);
            }
        }
        return result;
    }


    private void insert(Node root, Person p) {
        insert(root, p, p.frontCount);
    }

    private void insert(Node root, Person p, int value) {
        if (value < root.value) {
            if (root.left == null) {
                root.left = new Node(p);
            } else {
                insert(root.left, p, value);
            }
            root.value++; // value is frontCount
        } else {
            if (root.right == null) {
                root.right = new Node(p);
            } else {
                insert(root.right, p, value - root.value);
            }
        }
    }

    private void traverseInorder(Node root, List<Integer> list) {
        if (root == null || list == null) {
            return;
        }
        traverseInorder(root.left, list);
        list.add(root.person.height);
        traverseInorder(root.right, list);
    }

    class Node {
        Node left, right;
        int value;
        public final Person person;

        public Node(Person person) {
            this.value = 1;
            this.person = person;
        }
    }

    class Person {
        public final int height;
        public final int frontCount;

        Person(int height, int frontCount) {
            this.height = height;
            this.frontCount = frontCount;
        }
    }

    public static void main(String[] args) {
        OrderOfPeopleHeights ins = new OrderOfPeopleHeights();

        int[] heights = {5, 3, 2, 6, 1, 4};
        int[] frontCounts = {0, 1, 2, 0, 3, 2};
        int[] res = ins.order1(heights, frontCounts);
    }
}