package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by OlehKa on 08.06.2016.
 */
public class FindDuplicateInArray {

    // DO NOT MODIFY THE LIST
    public int repeatedNumberV1(final List<Integer> list) {
        int n = list.size(); // elements 1 .. n-1
        if (n < 2) return -1;
        if (n == 2) return 1;
        int range = (int) Math.sqrt(n - 1);
        if (range * range < n - 1) range++;
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i <= range; i++) {
            count.add(0);
        }
        for (int val : list) {
            int index = (val - 1) / range;
            int value = count.get(index);
            count.set(index, ++value);
        }
        int repeatingRange = -1;
        int numRanges = (n - 1 - 1) / range + 1;
        for (int i = 0; i < numRanges && repeatingRange == -1; i++) {
            if (i < numRanges - 1 || (n - 1) % range == 0) {
                if (count.get(i) > range) repeatingRange = i;
            } else {
                if (count.get(i) > (n - 1) % range) repeatingRange = i;
            }
        }
        if (repeatingRange == -1) return -1;
        count.clear();
        for (int i = 0; i <= range; i++) {
            count.add(0);
        }
        for (int i = 0; i < n; i++) {
            int index1 = (list.get(i) - 1) / range;
            int index2 = (list.get(i) - 1) % range;
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

    public int repeatedNumberV2(List<Integer> list) {
        if (list.size() == 0 || list.size() == 1) {
            return -1;
        }
        int size = list.size();
        double sqrt = Math.sqrt(size - 1);
        int numBuckets = (int)Math.ceil(sqrt);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : list) {
            int k = (value - 1) / numBuckets;
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }
        int bigBucket = -1, min = -1, max = -1;
        for (Integer k: map.keySet()) {
            if (map.get(k) > numBuckets) {
                bigBucket = k;
                break;
            }
        }
        if (bigBucket != -1) {
            min = bigBucket * numBuckets + 1;
            max = min + numBuckets - 1;
        } else if ((size - 1) % numBuckets != 0) {
            min = ((size - 1) / numBuckets) * numBuckets + 1;
            max = size - 1;
        }
        if (min != -1 && max != -1) {
            map.clear();
            for (int value : list) {
                if (value >= min && value <= max) {
                    if (map.containsKey(value)) {
                        return value;
                    } else {
                        map.put(value, 1);
                    }
                }
            }
        }
        return -1;
    }

    public int repeatedNumberXor(List<Integer> list) {
        int result = 0;
        for (int i = 1; i <= list.size() - 1; i++) {
            result = result ^ i;
        }
        for (int e: list) {
            result = result ^ e;
        }
        return result;
    }

    public static void main(String[] args) {
        FindDuplicateInArray ins = new FindDuplicateInArray();
        System.out.println(ins.repeatedNumberV2(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10)));
        System.out.println(ins.repeatedNumberV2(Arrays.asList(3, 4, 1, 4, 1)));
        System.out.println(ins.repeatedNumberV2(Arrays.asList(4, 7, 1, 8, 6, 8, 4, 3, 5)));
        System.out.println(ins.repeatedNumberV2(Arrays.asList()));
        System.out.println(ins.repeatedNumberV2(Arrays.asList(1)));
        System.out.println(ins.repeatedNumberV2(Arrays.asList(2,2)));

        System.out.println(ins.repeatedNumberXor(Arrays.asList(3,4,1,4,1)));
    }
}
