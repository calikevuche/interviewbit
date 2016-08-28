package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 08.06.2016.
 */
public class FindDuplicateInArray {

    // DO NOT MODIFY THE LIST
    public int repeatedNumber1(final List<Integer> a) {
        int n = a.size();
        if (n == 2) return 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(0);
        }
        for (int i = 0; i < n; i++) {
            if (numbers.get(a.get(i)) == 0) {
                numbers.set(a.get(i), 1);
            } else if (numbers.get(a.get(i)) == 1) {
                return a.get(i);
            }
        }
        return -1;
    }

    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int n = a.size(); // elements 1 .. n-1
        if (n < 2) return -1;
        if (n == 2) return 1;
        int range = (int) Math.sqrt(n-1);
        if (range * range < n-1) range++;
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i <= range; i++) {
            count.add(0);
        }
        for (int i = 0; i < n; i++) {
            int index = (a.get(i)-1) / range;
            int value = count.get(index);
            count.set(index, ++value);
        }
        int repeatingRange = -1;
        int numRanges = (n-1 - 1) / range + 1;
        for (int i = 0; i < numRanges && repeatingRange == -1; i++) {
            if (i < numRanges - 1 || (n-1) % range == 0) {
                if (count.get(i) > range) repeatingRange = i;
            } else {
                if (count.get(i) > (n-1) % range) repeatingRange = i;
            }
        }
        if (repeatingRange == -1) return -1;
        count.clear();
        for (int i = 0; i <= range; i++) {
            count.add(0);
        }
        for (int i = 0; i < n; i++) {
            int index1 = (a.get(i) - 1) / range;
            int index2 = (a.get(i) - 1) % range;
            int value = count.get(index2);
            if (index1 == repeatingRange) {
                count.set(index2, ++value);
            }
        }
        for (int i = 0; i < range; i++) {
            if (count.get(i) > 1) {
                return repeatingRange * range + i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicateInArray ins = new FindDuplicateInArray();
        System.out.println(ins.repeatedNumber(Arrays.asList(3,4,1,4,1)));
        System.out.println(ins.repeatedNumber(Arrays.asList(4,7,1,8,6,2,4,3,5)));
    }
}
