package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 03.07.2016.
 */
public class SearchForRange {

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int resLeft, resRight;

        resLeft = getResult(a, 0, a.size() - 1, b, true);
        resRight = getResult(a, 0, a.size() - 1, b, false);

        return new ArrayList<>(Arrays.asList(resLeft, resRight));
    }

    public int getResult(final List<Integer> a, int start, int end, int b, boolean isLeft) {
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (b == a.get(mid)) {
                result = mid;
                if (isLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (b < a.get(mid)) {
                end = mid - 1;
            } else if (b > a.get(mid)) {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SearchForRange instance = new SearchForRange();
        System.out.println(instance.searchRange(Arrays.asList(5, 7, 7, 8, 8, 10), 8));
        System.out.println(instance.searchRange(Arrays.asList(8, 8), 7));
        System.out.println(instance.searchRange(Arrays.asList(), 7));
    }
}
