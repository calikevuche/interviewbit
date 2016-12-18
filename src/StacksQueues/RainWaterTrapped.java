package StacksQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 26.10.2016.
 */
public class RainWaterTrapped {

    // DO NOT MODIFY THE LIST
    public int trap(final List<Integer> a) {
        int left = 0;
        int right = a.size()-1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (a.get(left) <= a.get(right)) {
                if (a.get(left) >= maxLeft) maxLeft = a.get(left);
                else res += maxLeft - a.get(left);
                left++;
            } else {
                if (a.get(right) >= maxRight) maxRight = a.get(right);
                else res += maxRight - a.get(right);
                right--;
            }
        }
        return res;
    }

    // DO NOT MODIFY THE LIST
    public int trap2(final List<Integer> A) {
        int n = A.size();
        int rightMax[], leftMax[];
        int left, right;
        int res = 0;

        rightMax = new int[n];
        leftMax = new int[n];

        left = 0;
        right = 0;

        for (int i = 0; i < n; i++) {
            leftMax[i] = left;
            if (left < A.get(i))
                left = A.get(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = right;
            if (right < A.get(i))
                right = A.get(i);
        }

        for (int i = 0; i < n; i++) {

            res += Math.max(0, Math.min(leftMax[i], rightMax[i]) - A.get(i));

        }


        return res;
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
