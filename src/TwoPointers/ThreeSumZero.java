package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * Created by OlehKa on 19.08.2016.
 */
public class ThreeSumZero {

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        Collections.sort(a);
        for (int i = 0; i < a.size() - 2; i++) {
            if (i > 0 && Objects.equals(a.get(i), a.get(i - 1))) continue;
            int left = i + 1;
            int right = a.size() - 1;
            int target = 0 - a.get(i);
            while (left < right) {
                if (a.get(left) + a.get(right) > target) right--;
                else if (a.get(left) + a.get(right) < target) left++;
                else {
                    ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(a.get(i), a.get(left), a.get(right)));
                    triplets.add(newList);
                    int leftValue = a.get(left);
                    int rightValue = a.get(right);
                    while (left < a.size() - 1 && a.get(left) == leftValue) left++;
                    while (right >= 0 && a.get(right) == rightValue) right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        ThreeSumZero instance = new ThreeSumZero();
//        System.out.println(instance.threeSum(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4))));
//        System.out.println(instance.threeSum(new ArrayList<>(Arrays.asList(-1, 1, -1, -1, 1, 0, -1, -1, 1, -1))));
//        System.out.println(instance.threeSum(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0))));
//        System.out.println(instance.threeSum(new ArrayList<>(Arrays.asList( 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 ))));
//        System.out.println(instance.threeSum(new ArrayList<>(Arrays.asList( -4, 2, -1, 1, -4, 2, -5, -3, 2 ))));
        System.out.println(instance.threeSum(new ArrayList<>(Arrays.asList(-31013930, -31013930, 9784175, 21229755))));
    }
}
