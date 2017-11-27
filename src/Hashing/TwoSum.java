package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by OlehKa on 22.12.2016.
 */
public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        int id1 = -1, id2 = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (!map.containsKey(a.get(i))) {
                map.put(a.get(i), i);
            }
        }
        for (int i = 0; i < a.size(); i++) {
            int diff = b - a.get(i);
            if (map.containsKey(diff)) {
                int j = map.get(diff);
                if (i == j) continue;
                int x1 = (i < j) ? i : j;
                int x2 = (i < j) ? j : i;
                if (id2 == -1 || x2 < id2) {
                    id2 = x2;
                    id1 = x1;
                } else if (id1 == -1 || (id2 == x2 && x1 < id1)) {
                    id1 = x1;
                    id2 = x2;
                }
            }
        }

        return (id1 != -1 && id2 != -1) ? new ArrayList<>(Arrays.asList(id1 + 1, id2 + 1)) : new ArrayList<>();
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        ArrayList<Integer> list = twoSum.twoSum(Arrays.asList(2, 7, 11, 15), 9);
//        ArrayList<Integer> list2 = twoSum.twoSum(Arrays.asList(2, -7, 11, 15), -5);
//        ArrayList<Integer> list3 = twoSum.twoSum(Arrays.asList(2, -7, -11, 15), -18);
        ArrayList<Integer> list4 = twoSum.twoSum(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8), -3);
//        System.out.println(list);
//        System.out.println(list2);
//        System.out.println(list3);
        System.out.println(list4);
    }
}
