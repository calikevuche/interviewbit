package StacksQueues;

import java.util.*;

/**
 * Created by OlehKa on 18.10.2016.
 */
public class SlidingWindowMax {

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        ArrayList<Integer> maxValues = new ArrayList<>();
        if (a.size() == 0) return maxValues;
        else if (b >= a.size()) {
            maxValues.add(getMax(a));
            return maxValues;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < b; i++) {
            while (!queue.isEmpty() && a.get(queue.get(0)) <= a.get(i)) {
                queue.remove(0);
            }
            queue.add(0, i);
        }
        for (int i = b; i < a.size(); i++) {
            maxValues.add(a.get(queue.get(queue.size() - 1)));
            while (!queue.isEmpty() && a.get(queue.get(0)) <= a.get(i)) {
                queue.remove(0);
            }
            while (!queue.isEmpty() && (i >= queue.get(queue.size() - 1) + b)) {
                queue.remove(queue.size() - 1);
            }
            queue.add(0, i);
        }
        maxValues.add(a.get(queue.get(queue.size() - 1)));
        return maxValues;
    }

    private int getMax(List<Integer> list) {
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > result) result = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMax instance = new SlidingWindowMax();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        instance.slidingMaximum(list, 2);
    }
}
