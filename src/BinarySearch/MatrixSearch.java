package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 02.07.2016.
 */
public class MatrixSearch {

    // return 0 - if element not present, 1 - if present
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int lastRow = a.size() - 1;
        if (lastRow == -1) return 0;
        int lastColumn = a.get(0).size() - 1;
        if (b < a.get(0).get(0) || b > a.get(lastRow).get(lastColumn)) return 0;
        int start = 0;
        int end = lastRow;
        int rowIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (b == a.get(mid).get(0)) return 1;
            else if (b < a.get(mid).get(0)) {
                end = mid - 1;
            } else if (b > a.get(mid).get(0)) {
                start = mid + 1;
                rowIndex = mid;
            }
        }

        start = 0;
        end = lastColumn;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (b == a.get(rowIndex).get(mid)) return 1;
            else if (b < a.get(rowIndex).get(mid)) {
                end = mid - 1;
            } else if (b > a.get(rowIndex).get(mid)) {
                start = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        MatrixSearch instance = new MatrixSearch();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

//        A.add(new ArrayList<>(Arrays.asList(20, 21, 44, 48, 62, 64, 65, 73, 77)));
        A.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        A.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        A.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));

//        A.add(new ArrayList<>(Arrays.asList(3)));
//        A.add(new ArrayList<>(Arrays.asList(29)));
//        A.add(new ArrayList<>(Arrays.asList(36)));
//        A.add(new ArrayList<>(Arrays.asList(63)));
//        A.add(new ArrayList<>(Arrays.asList(67)));
//        A.add(new ArrayList<>(Arrays.asList(72)));
//        A.add(new ArrayList<>(Arrays.asList(74)));
//        A.add(new ArrayList<>(Arrays.asList(78)));
//        A.add(new ArrayList<>(Arrays.asList(83)));

        System.out.println(instance.searchMatrix(A, 10));
    }
}
