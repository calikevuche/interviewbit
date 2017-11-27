package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by OlehKa on 24.12.2016.
 */
public class Equal {

    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                long sum = a.get(i) + a.get(j);
                if (map.containsKey(sum)) {
                    List<Integer> list = map.get(sum);
                    if (list.size() == 2) {
                        int i1 = list.get(0);
                        int i2 = list.get(1);
                        if (i1 < i && i2 != j && i2 != i) {
                            list.add(i);
                            list.add(j);

                            if (res.isEmpty()) {
                                res.addAll(list);
                            } else {
                                if (
                                        list.get(0) < res.get(0) ||
                                                list.get(0) == res.get(0) && list.get(1) < res.get(1) ||
                                                list.get(0) == res.get(0) && list.get(1) == res.get(1) && list.get(2) < res.get(2) ||
                                                list.get(0) == res.get(0) && list.get(1) == res.get(1) && list.get(2) == res.get(2) && list.get(3) < res.get(3)
                                        ) {
                                    res.clear();
                                    res.addAll(list);
                                }
                            }
                        }
                    }
                } else {
                    map.put(sum, new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Equal equal = new Equal();
        System.out.println(equal.equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8))));
    }
}
