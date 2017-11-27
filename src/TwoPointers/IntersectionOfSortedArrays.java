package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 21.08.2016.
 */
public class IntersectionOfSortedArrays {

    // DO NOT MODIFY THE LISTS
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a.size() == 0 || b.size() == 0) return result;
        int leftA = 0, leftB = 0, rightA = a.size() - 1, rightB = b.size() - 1;
        while (leftA <= rightA && leftB <= rightB) {
            if (a.get(leftA).intValue() == b.get(leftB).intValue()) {
                result.add(a.get(leftA));
                leftA++;
                leftB++;
            } else if (a.get(leftA) < b.get(leftB)) {
                leftA++;
            } else {
                leftB++;
            }
//            if (a.get(rightA).intValue() == b.get(rightB).intValue()) {
//                result.add(a.get(rightA));
//                rightA--;
//                rightB--;
//            } else if (a.get(rightA) > b.get(rightB)) {
//                rightA--;
//            } else {
//                rightB--;
//            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfSortedArrays instance = new IntersectionOfSortedArrays();
        System.out.println(instance.intersect(Arrays.asList(1, 2, 3, 3, 4, 5, 6), Arrays.asList(3, 3, 5)));
        System.out.println(instance.intersect(Arrays.asList(1, 2, 3, 3, 4, 5, 6), Arrays.asList(3, 5)));
        System.out.println(instance.intersect(Arrays.asList(1, 2, 3, 3, 4, 5, 6), Arrays.asList(1)));
    }
}
