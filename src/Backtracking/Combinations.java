package Backtracking;

import java.util.ArrayList;

/**
 * Created by OlehKa on 26.11.2016.
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> comb = new ArrayList<>();
        combine(result, comb, 1, n , k);
        return  result;
    }

    void combine(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> comb, int i, int n, int k) {
        if (i > n) {
            return;
        }
        ArrayList<Integer> copy = new ArrayList<>(comb);
        copy.add(i);
        if (copy.size() == k) {
            result.add(copy);
        }
        combine(result, copy, i+1, n, k);
        combine(result, comb, i+1, n, k);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(5,3));
    }
}
