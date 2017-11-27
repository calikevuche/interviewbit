package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 16.07.2016.
 */
public class MedianOfArray {

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int m = a.size();
        int n = b.size();
        if (m > n) {
            return findMedianSortedArrays(b, a);
        }
        if (m == 0 && n == 0) return -1;
        if (m == 0 && n == 1) return b.get(0);
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i > 0 && j < n && a.get(i - 1) > b.get(j)) {
                iMax = i - 1;
            } else if (j > 0 && i < m && b.get(j - 1) > a.get(i)) {
                iMin = i + 1;
            } else {
                int value1, value2;
                if (i == 0) {
                    value1 = b.get(j - 1);
                } else if (j == 0) {
                    value1 = a.get(i - 1);
                } else {
                    value1 = Math.max(a.get(i - 1), b.get(j - 1));
                }
                if ((m + n) % 2 == 1) {
                    return value1;
                } else {
                    if (i == m) {
                        value2 = b.get(j);
                    } else if (j == n) {
                        value2 = a.get(i);
                    } else {
                        value2 = Math.min(a.get(i), b.get(j));
                    }
                    return ((double) value1 + (double) value2) / 2;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MedianOfArray instance = new MedianOfArray();
//        System.out.println(instance.findMedianSortedArrays(Arrays.asList(1,2,5), Arrays.asList(3)));
//        System.out.println(instance.findMedianSortedArrays(Arrays.asList(16,19), Arrays.asList(-46,-15,-9,-7,-2,24,40)));
//        System.out.println(instance.findMedianSortedArrays(Arrays.asList(0,1,4,5,6,9), Arrays.asList(2,7,8)));
//        System.out.println(instance.findMedianSortedArrays(Arrays.asList(), Arrays.asList(2,7,8,10)));
//        System.out.println(instance.findMedianSortedArrays(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40), Arrays.asList(-2)));
//        System.out.println(instance.findMedianSortedArrays(Arrays.asList(), Arrays.asList(4)));
        System.out.println(instance.findMedianSortedArrays(Arrays.asList(-49, 33, 35, 42), Arrays.asList(-26)));
    }
}
