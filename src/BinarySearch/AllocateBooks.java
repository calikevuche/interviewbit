package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 08.07.2016.
 */
public class AllocateBooks {

    public int books(ArrayList<Integer> a, int b) {
        if (a.size() < b || a.size() == 0 || b < 1) {
            return -1;
        }

        long sum = 0;
        for (int element: a) {
            sum += element;
        }

        int start = Collections.max(a);
        int end = sum > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) sum;

        while (start < end) {
            int mid = (start + end) / 2;
            if (isPossible(mid, b, a)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    boolean isPossible(int value, int counter, ArrayList<Integer> list) {
        int innerSum = 0;
        int innerCounter = 1;

        for (int i = 0; i < list.size(); i++) {
            innerSum += list.get(i);
            if (innerSum > value) {
                innerSum = 0;
                i--;
                innerCounter++;
            }
            if (innerCounter > counter) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AllocateBooks instance = new AllocateBooks();
        System.out.println(instance.books(new ArrayList<>(Arrays.asList(12, 34, 67, 90)), 2));
    }
}
