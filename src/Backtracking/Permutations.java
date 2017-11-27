package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 27.11.2016.
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permute(result, a, new ArrayList<>(), 0);
        return result;
    }

    void permute(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> input, ArrayList<Integer> output, int i) {
        if (input.size() == 1) {
            output.add(input.get(0));
            result.add(output);
            return;
        }
        if (i >= input.size()) {
            return;
        }
        ArrayList<Integer> newInput = new ArrayList<>(input);
        ArrayList<Integer> newOutput = new ArrayList<>(output);
        int removed = newInput.remove(i);
        newOutput.add(removed);
        permute(result, newInput, newOutput, 0);
        permute(result, input, output, i + 1);
    }

    //Second solution

    public ArrayList<ArrayList<Integer>> permute2(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permute(a, 0, result);
        return result;
    }

    void permute(ArrayList<Integer> list, int start, ArrayList<ArrayList<Integer>> result) {
        if (start == list.size() - 1) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            if (!result.contains(newList)) {
                result.add(newList);
            }
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            permute(list, start + 1, result);
            Collections.swap(list, start, i);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
//        System.out.println(permutations.permute(new ArrayList<>(Arrays.asList(1,2,3,4))));
        System.out.println(permutations.permute2(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
    }
}
