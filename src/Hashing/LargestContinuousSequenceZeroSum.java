package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by OlehKa on 19.12.2016.
 */
public class LargestContinuousSequenceZeroSum {

    //ver 1.0
    public ArrayList<Integer> lszero2(ArrayList<Integer> a) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        ArrayList<Integer> subList;
        int L = 0;
        int R = 1;
        int sum, maxKey = -1;

        while (L < a.size() && a.size() - L > maxKey) {
            sum = 0;
            while (R < a.size() + 1) {
                sum += a.get(R - 1);
                if (sum == 0 && !map.containsKey(R - L + 1)) {
                    subList = new ArrayList<>(a.subList(L, R));
                    map.put(R - L + 1, subList);
                    if (maxKey < R - L + 1) maxKey = R - L + 1;
                }
                R++;
            }
            L++;
            R = L + 1;
        }

        if (map.isEmpty()) {
            return new ArrayList<>();
        } else {
            return map.get(maxKey);
        }
    }

    //ver 2.0
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        HashMap<Long, Integer> map = new HashMap<>(); // key - sum, value - first index
        long sum = 0;
        int from = -1, to = -1;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            if (map.containsKey(sum)) {
                int id = map.get(sum);
                if (i - id > to - from) {
                    from = id + 1;
                    to = i + 1;
                }
            } else {
                map.put(sum, i);
            }
            if (sum == 0) {
                from = 0;
                to = i + 1;
            }
        }

        if (from != -1 && to != -1) {
            return new ArrayList<>(a.subList(from, to));
        } else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        LargestContinuousSequenceZeroSum instance = new LargestContinuousSequenceZeroSum();
        ArrayList<Integer> result = instance.lszero(new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4)));
//        ArrayList<Integer> result = instance.lszero(new ArrayList<>(Arrays.asList(1, 2, -3, 3)));
        System.out.println(result);
    }
}
