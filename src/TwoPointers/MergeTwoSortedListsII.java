package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 21.08.2016.
 */
public class MergeTwoSortedListsII {

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() == 0) {
            a.addAll(b);
            return;
        }
        int leftA = 0;
        int leftB = 0;
        while (leftA < a.size() && leftB < b.size()) {
            while (leftA < a.size() && a.get(leftA) < b.get(leftB)) leftA++;
            a.add(leftA, b.get(leftB++));
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedListsII instance = new MergeTwoSortedListsII();
        instance.merge(new ArrayList<>(Arrays.asList(1,5,8)), new ArrayList<>(Arrays.asList(6,9)));
        instance.merge(new ArrayList<>(Arrays.asList(1,5,8)), new ArrayList<>(Arrays.asList(6,9,11,12)));
        instance.merge(new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList(1,2)));
    }
}
