package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 05.06.2016.
 */
public class MaxNonNegativeSubArray {

    public ArrayList<Integer> maxNonNegSubArr(ArrayList<Integer> a) {
        long maxSum = 0, sum = 0;
        int id1 = 0, id2 = 0, max1 = -1, max2 = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) {
                if (i == 0 || a.get(i - 1) < 0) {
                    id1 = i;
                }
                sum += a.get(i);
                id2 = i;
                if (sum > maxSum ||
                        (sum == maxSum && (id2 - id1) > (max2 - max1))) {
                    maxSum = sum;
                    max1 = id1;
                    max2 = id2;
                }
            } else {
                sum = 0;
            }
        }
        if (max1 != -1) {
            return new ArrayList<>(a.subList(max1, max2 + 1));
        } else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MaxNonNegativeSubArray instance = new MaxNonNegativeSubArray();
        System.out.println(instance.maxNonNegSubArr(new ArrayList<>(Arrays.asList(1, 2, 5, -7, 2, 5))));
    }
}
