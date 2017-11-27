package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 21.11.2016.
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        subsets(a, result, result.get(0), 0);
        return result;
    }

    void subsets(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> set, int i) {
        if (i > input.size() - 1) {
            return;
        }
        ArrayList<Integer> newSet = new ArrayList<>(set);
        newSet.add(input.get(i));
        result.add(newSet);
        subsets(input, result, newSet, i + 1);
        subsets(input, result, set, i + 1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new ArrayList<>(Arrays.asList(1, 2, 3))));
//        System.out.println(subsets.subsets(new ArrayList<>(Arrays.asList(15, 20, 12, 19, 4 ))));
    }
}
