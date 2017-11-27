package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 26.11.2016.
 */
public class Subsets2 {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
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
        int j = i + 1;
        while (j < input.size() && input.get(j) == input.get(i)) {
            j++;
        }
        subsets(input, result, set, j);
    }

    public static void main(String[] args) {
        Subsets2 subsets = new Subsets2();
        System.out.println(subsets.subsetsWithDup(new ArrayList<>(Arrays.asList(1, 2, 2))));
    }
}
