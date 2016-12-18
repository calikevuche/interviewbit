package Levels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by OlehKa on 01.09.2016.
 */
public class L3KthSmallestElementInTheArray {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest1(final List<Integer> a, int k) {
        List<Integer> b = new ArrayList<>(a);
        Collections.sort(b);
        if (k-1 < b.size()) return b.get(k-1);
        else return -1;
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest2(final List<Integer> a, int k) {
        List<Integer> heap = new ArrayList<>();
        int max = -1;
        int index = -1;
        for (int i = 0; i < a.size(); i++) {
            if (heap.size() < k) {
                heap.add(a.get(i));
                if (a.get(i) > max) {
                    max = a.get(i);
                    index = heap.size()-1;
                }
            } else {
                if (a.get(i) < max) {
                    heap.remove(index);
                    heap.add(a.get(i));
                    max = heap.get(0);
                    index = 0;
                    for (int j = 1; j < heap.size(); j++) {
                        if (heap.get(j) > max) {
                            max = heap.get(j);
                            index = j;
                        }
                    }
                }
            }
        }
        return max;
    }

    public int quickSort(List<Integer> li, int k, int start, int end) {
        int pos = partition(li, start, end);
        if (pos == k-1) {
            return li.get(pos);
        } else if (pos > k-1) {
            return quickSort(li, k, start, pos);
        } else {
            return quickSort(li, k, pos+1, end);
        }
    }

    public int partition(List<Integer> list, int start, int end) {
        int pivot = start;
        int j = start+1;
        for (int i = start+1; i < end; i++) {
            if (list.get(i) < list.get(pivot)) {
                int temp = list.get(j);
                list.set(j, list.get(i));
                list.set(i, temp);
                j++;
            }
        }
        if (j <= end) {
            int temp = list.get(j-1);
            list.set(j-1, list.get(pivot));
            list.set(pivot, temp);
        }
        return j-1;
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> a, int k) {
        return quickSort(new ArrayList<>(a), k, 0, a.size());
    }

    public static void main(String[] args) {
        L3KthSmallestElementInTheArray instance = new L3KthSmallestElementInTheArray();
        instance.kthsmallest(new ArrayList<>(Arrays.asList(2,1,4,3,2)), 3);
        instance.kthsmallest(new ArrayList<>(Arrays.asList(60, 94, 63, 3, 86, 40, 93, 36, 56, 48, 17, 10, 23, 43, 77, 1, 1, 93, 79, 4, 10, 47, 1, 99, 91, 53, 99, 18, 52, 61, 84, 10, 13, 52, 3, 9, 78, 16, 7, 62)), 22);
    }
}
