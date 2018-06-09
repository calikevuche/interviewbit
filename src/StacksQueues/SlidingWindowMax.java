package StacksQueues;

import java.util.*;

/**
 * Created by OlehKa on 18.10.2016.
 */
public class SlidingWindowMax {

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int w) {
        ArrayList<Integer> maxValues = new ArrayList<>();
        if (A.size() == 0) {
            return maxValues;
        } else if (w >= A.size()) {
            maxValues.add(getMax(A));
            return maxValues;
        }
        LinkedList<Integer> queue = new LinkedList<>(); // indexes
        for (int i = 0; i < w; i++) {
            while (!queue.isEmpty() && A.get(i) >= A.get(queue.getFirst())) {
                queue.pollFirst();
            }
            queue.addFirst(i);
        }
        maxValues.add(A.get(queue.getLast()));
        for (int i = w; i < A.size(); i++) {
            while (!queue.isEmpty() && A.get(i) >= A.get(queue.getFirst())) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && (i > queue.getLast() + w - 1)) {
                queue.removeLast();
            }
            queue.addFirst(i);
            maxValues.add(A.get(queue.getLast()));
        }
        return maxValues;
    }

    private int getMax(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > result) {
                result = list.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMax instance = new SlidingWindowMax();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        instance.slidingMaximum(list, 2);
    }
}
