package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by OlehKa on 31.05.2016.
 */
public class SortingAlgorithms {

    void mergeSortAlgo(List<Integer> array) {
        int n = array.size();
        if (n == 1) return;
        List<Integer> left = new ArrayList<>(array).subList(0, n / 2);
        List<Integer> right = new ArrayList<>(array).subList(n / 2, n);
        mergeSortAlgo(left);
        mergeSortAlgo(right);
        merge(left, right, array);
        System.out.println(array);
    }

    void merge(List<Integer> left, List<Integer> right, List<Integer> result) {
        int i = 0, j = 0, k = 0; // i -left, j - right, k - result
        while (i < left.size() && j < right.size()) {
            if (left.get(i) > right.get(j)) {
                result.set(k, right.get(j));
                j++;
            } else {
                result.set(k, left.get(i));
                i++;
            }
            k++;
        }
        while (i < left.size()) {
            result.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            result.set(k, right.get(j));
            j++;
            k++;
        }
    }

    void quickSotrAlgo(List<Integer> array, int start, int end) {
        if (start < end) {
            int pIndex = partitionQS(array, start, end);
            quickSotrAlgo(array, start, pIndex - 1);
            quickSotrAlgo(array, pIndex + 1, end);
        }
    }

    int partitionQS(List<Integer> array, int start, int end) {
        System.out.println(new ArrayList<>(array).subList(start, end + 1));
        int pIndex = start;
        int pivot = array.get(end); // end - pivot index
        for (int i = start; i < end; i++) {
            if (array.get(i) < pivot) {
                int temp = array.get(pIndex);
                array.set(pIndex, array.get(i));
                array.set(i, temp);
                pIndex++;
            }
        }
        int temp = array.get(pIndex);
        array.set(pIndex, pivot);
        array.set(end, temp);
        System.out.println("==>" + new ArrayList<>(array).subList(start, end + 1));
        return pIndex;
    }

    public static void main(String[] args) {
        SortingAlgorithms instance = new SortingAlgorithms();
        List<Integer> list = Arrays.asList(3, 5, 2, 6, 1, 7, 9, 4);
//        instance.mergeSortAlgo(list);
        instance.quickSotrAlgo(list, 0, list.size() - 1);
        System.out.println(list);
    }
}
