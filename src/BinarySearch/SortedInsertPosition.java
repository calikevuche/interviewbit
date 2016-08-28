package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 03.07.2016.
 */
public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> a, int b) {

        if (a.size() == 0) return 0;

        int start = 0, end = a.size()-1;

        if (b < a.get(start)) return 0;
        else if (b > a.get(end)) return end+1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (b == a.get(mid)) {
                return mid;
            }
            else if (b < a.get(mid)) {
                end = mid - 1;
            }
            else if (b > a.get(mid)) {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        SortedInsertPosition instance = new SortedInsertPosition();
        System.out.println(instance.searchInsert(new ArrayList<>(Arrays.asList(0,1,2,3,4)), 2));
        System.out.println(instance.searchInsert(new ArrayList<>(Arrays.asList(0,1,3,4)), 2));
        System.out.println(instance.searchInsert(new ArrayList<>(Arrays.asList(0,1,2,4)), 3));
        System.out.println(instance.searchInsert(new ArrayList<>(Arrays.asList(1,2,4)), 0));
        System.out.println(instance.searchInsert(new ArrayList<>(Arrays.asList(0,1,2,4)), 5));
    }
}
