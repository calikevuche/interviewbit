package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 27.08.2016.
 */
public class Array3Pointers {

    // DO NOT MODIFY THE LISTS
    public int minimize1(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int minResult;
        int i = 0, j = 0, k = 0;
        minResult = Math.max(Math.abs(a.get(i)-b.get(j)), Math.abs(b.get(j)-c.get(k)));
        minResult = Math.max(minResult, Math.abs(c.get(k)-a.get(i)));
        for (i=0; i < a.size(); i++) {
            for (j=0; j < b.size(); j++) {
                if (Math.abs(a.get(i)-b.get(j)) > minResult) continue;
                for (k=0; k < c.size(); k++) {
                    if (Math.abs(c.get(k)-a.get(i)) > minResult) continue;
                    if (Math.abs(c.get(k)-b.get(j)) > minResult) continue;
                    int tempMin = Math.max(Math.abs(a.get(i)-b.get(j)), Math.abs(b.get(j)-c.get(k)));
                    tempMin = Math.max(tempMin, Math.abs(c.get(k)-a.get(i)));
                    if (tempMin < minResult) minResult = tempMin;
                }
            }
        }
        return minResult;
    }

    // DO NOT MODIFY THE LISTS
    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int result=0;
        int max = Math.max(Math.max(a.get(0), b.get(0)), c.get(0));
        int min = Math.min(Math.min(a.get(0), b.get(0)), c.get(0));
        result = max - min;
        int i = 0, j = 0, k = 0;
        while (i < a.size() && j < b.size() && k < c.size()) {
            max = Math.max(Math.max(a.get(i), b.get(j)), c.get(k));
            min = Math.min(Math.min(a.get(i), b.get(j)), c.get(k));
            result = Math.min(result, max-min);
            if (result == 0) break;
            if (a.get(i) == min) i++;
            else if (b.get(j) == min) j++;
            else k++;
        }
        return result;
    }

    public static void main(String[] args) {
        Array3Pointers instance = new Array3Pointers();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(24, 25, 44, 51, 57, 65, 69, 109, 124, 139, 140, 174, 183, 221, 224, 225, 228, 240, 248, 253, 261, 262, 265, 270, 281, 292, 297, 300, 320, 333, 355, 363, 381, 388, 390, 391, 396, 404, 405, 426, 449, 455, 458, 459, 460, 461, 468, 469, 474, 484, 484, 501, 502, 506, 506, 507, 540));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(44, 44, 48, 65, 68, 111, 123, 129, 138, 142, 151, 191, 198, 211, 220, 223, 223, 259, 305, 324, 324, 326, 354, 354, 359, 359, 359, 363, 389, 396, 404, 405, 417, 438, 441, 445, 445, 457, 460, 481, 493, 493, 497, 503, 512));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(43, 64, 67, 71, 74, 104, 112, 144, 153, 161, 182, 184, 196, 253, 264, 344, 345, 354, 377, 378, 427, 441, 481, 502, 506));
        System.out.println(instance.minimize(a,b,c));
    }
}
