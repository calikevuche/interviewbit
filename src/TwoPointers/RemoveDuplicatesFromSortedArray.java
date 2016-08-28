package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 24.08.2016.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates1(ArrayList<Integer> a) {
        if (a.size() == 0) return 0;
        int i = 1;
        int prev = a.get(0);
        while (i < a.size()) {
            int value = a.get(i);
            if (value == prev) {
                a.remove(i);
                i--;
            } else {
                prev = value;
            }
            i++;
        }
        System.out.println(a);
        return a.size();
    }

    //better solution
    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() == 0) return 0;
        int i = 1;
        int prev = a.get(0);
        while (i < a.size()) {
            int value = a.get(i);
            if (value == prev) {
                int lastIndex = findLastIndex(a, i);
                a.subList(i,lastIndex+1).clear();
                i--;
            } else {
                prev = value;
            }
            i++;
        }
        System.out.println(a);
        return a.size();
    }

    public int findLastIndex(ArrayList<Integer> a, int firstIndex) {
        int left = firstIndex, right = a.size()-1;
        int number = a.get(firstIndex);
        while (left < right) {
            int mid = (left+right)/2;
            if (a.get(mid) == number) {
                if (a.get(mid+1) != number) return mid;
                else left = mid+1;
            } else if (a.get(mid) > number) {
                right = mid-1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray instance = new RemoveDuplicatesFromSortedArray();
        instance.removeDuplicates(new ArrayList<>(Arrays.asList(1,1,2)));
        instance.removeDuplicates(new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,2,2,2,2,2,2,2)));
        instance.removeDuplicates(new ArrayList<>(Arrays.asList()));
//        System.out.println(instance.findLastIndex(new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,2,2,2,2,2,2,2)), 0));
    }
}
