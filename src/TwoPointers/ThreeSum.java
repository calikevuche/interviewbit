package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 19.08.2016.
 */
public class ThreeSum {

    // bad version
    public int threeSumClosest1(ArrayList<Integer> a, int b) {
        long sum = a.get(0) + a.get(1) + a.get(2);
        for (int i = 0; i < a.size(); i++) {
            long num1 = a.get(i);
            for (int j = 0; j < a.size(); j++) {
                long num2 = a.get(j);
                for (int k = 0; k < a.size(); k++) {
                    long num3 = a.get(k);
                    long tempSum = num1 + num2 + num3;
                    if (i != j && j != k && i != k && tempSum == b) {
                        System.out.println("[" + num1 + " " + num2 + " " + num3 + "]");
                        return (int) tempSum;
                    }
                    if (i != j && j != k && i != k && Math.abs(tempSum - b) < Math.abs(sum - b)) {
                        sum = tempSum;
                        System.out.println("[" + num1 + " " + num2 + " " + num3 + "]");
                    }
                }
            }
        }
        return sum > Integer.MAX_VALUE ? Integer.MAX_VALUE : sum < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) sum;
    }

    // better version
    public int threeSumClosest(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        int bestSum = a.get(0) + a.get(1) + a.get(2);
        int target = b;

        loop1:
        for (int i = 0; i < a.size() - 2; i++) {
            int left = i + 1, right = a.size() - 1;
            while (left < right) {
                int sum = a.get(i) + a.get(left) + a.get(right);
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) bestSum = sum;
                if (sum < target) left++;
                else if (sum > target) right--;
                else {
                    bestSum = a.get(i) + a.get(left) + a.get(right);
                    break loop1;
                }
            }
        }
        return bestSum;
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
//        System.out.println(instance.threeSumClosest(new ArrayList<>(Arrays.asList(-4,-1,2,1)), 1));
        System.out.println(instance.threeSumClosest(new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10)), 5));
    }
}
