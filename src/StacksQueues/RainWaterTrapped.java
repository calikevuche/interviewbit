package StacksQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 26.10.2016.
 */
public class RainWaterTrapped {

    public int trap1(final List<Integer> A) {
        int result = 0;
        int left = 0, right = A.size() - 1;
        int maxL = 0, maxR = 0;
        while (left <= right) {
            if (A.get(left) <= A.get(right)) {
                if (A.get(left) > maxL) {
                    maxL = A.get(left);
                } else {
                    result += maxL - A.get(left);
                }
                left++;
            } else {
                if (A.get(right) > maxR) {
                    maxR = A.get(right);
                } else {
                    result += maxR - A.get(right);
                }
                right--;
            }
        }
        return result;
    }

    public int trap2(final List<Integer> A) {
        int result = 0;
        int n = A.size();
        int maxL = 0, maxR = 0;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        for (int i = 0; i < n; i++) {
            leftMax[i] = maxL;
            if (maxL < A.get(i)) {
                maxL = A.get(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = maxR;
            if (maxR < A.get(i)) {
                maxR = A.get(i);
            }
        }
        for (int i = 0; i < n; i++) {
            result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        RainWaterTrapped instance = new RainWaterTrapped();
//        instance.trap(new ArrayList<>(Arrays.asList(1,0,1,0,1,0,1)));
//        instance.trap(new ArrayList<>(Arrays.asList(2,1,0,1,2)));
//        instance.trap(new ArrayList<>(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1)));
//        instance.trap(new ArrayList<>(Arrays.asList(8, 71, 58, 31, 89, 18, 67, 35, 53, 100, 42)));
        instance.trap2(new ArrayList<>(Arrays.asList(2, 9, 7, 6, 10, 3, 5, 4, 6, 1, 3)));
    }
}
