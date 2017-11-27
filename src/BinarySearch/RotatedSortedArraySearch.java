package BinarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 15.07.2016.
 */
public class RotatedSortedArraySearch {

    // DO NOT MODIFY THE LIST
    public int search0(final List<Integer> a, int b) {
        int n = a.size();
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) > b) {
                if ((a.get(mid) > a.get(start) && a.get(start) <= b) || (a.get(start) > a.get(mid))) {
                    end = mid - 1;
                } else if (a.get(mid) > a.get(end) && a.get(end) >= b) {
                    start = mid + 1;
                } else {
                    break;
                }
            } else if (a.get(mid) < b) {
                if ((a.get(mid) < a.get(end) && a.get(end) >= b) || (a.get(mid) > a.get(end))) {
                    start = mid + 1;
                } else if (a.get(mid) < a.get(start) && a.get(start) <= b) {
                    end = mid - 1;
                } else {
                    break;
                }
            }
        }

        return -1;
    }

    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        int n = a.size();
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) <= a.get(end)) { // sorted is right part
                if (b > a.get(mid) && b <= a.get(end)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (a.get(mid) > a.get(start)) { // sorted is left part
                if (a.get(start) <= b && b < a.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch instance = new RotatedSortedArraySearch();
        System.out.println(instance.search(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 1));
        System.out.println(instance.search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 8));
        System.out.println(instance.search(Arrays.asList(7, 8, 0, 2, 3, 4, 6), 5));
        System.out.println(instance.search(Arrays.asList(7, 8, 0, 2, 3, 4, 6), 44));
        System.out.println(instance.search(Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177), 42));
    }
}
