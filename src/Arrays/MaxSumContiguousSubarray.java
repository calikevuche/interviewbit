package Arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 29.05.2016.
 */
public class MaxSumContiguousSubarray {

    // DO NOT MODFIY THE LIST

    public int MSS_N3(final List<Integer> array) {
        if (array.size() == 0) return 0;
        int L = 0 ,R = array.size() - 1;
        int sum, maxSum = array.get(0);
        while (L <= R) {
            while (L <= R) {
                sum = 0;
                for (int j = L; j <= R; j++) {
                    sum += array.get(j);
                }
                if (sum > maxSum) maxSum = sum;
                L++;
            }
            R--;
            L = 0;
        }
        return maxSum;
    }

    public int MSS_N2(final List<Integer> array) {
        if (array.size() == 0) return 0;
        int L = 0, R = 0;
        int sum, maxSum = array.get(0);
        while (L < array.size()) {
            sum = 0;
            while (R < array.size()) {
                sum += array.get(R);
                if (sum > maxSum) maxSum = sum;
                R++;
            }
            L++;
            R = L;
        }
        return maxSum;
    }

    // O(N * logN)

    int MSS_divideAndConquer(List<Integer> array, int size) {
        if (size == 1) {
            return array.get(0);
        }
        int middle = size / 2;
        int leftMSA = MSS_divideAndConquer(array, middle);
        int rightMSA = MSS_divideAndConquer(array.subList(middle, array.size()), size - middle);
        int maxLeftPart = Integer.MIN_VALUE;
        int maxRightPart = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = middle; i < size; i++) {
            sum += array.get(i);
            if (sum > maxRightPart) maxRightPart = sum;
        }
        sum = 0;
        for (int i = middle - 1; i >= 0; i--) {
            sum += array.get(i);
            if (sum > maxLeftPart) maxLeftPart = sum;
        }
        return Math.max(
                Math.max(leftMSA, rightMSA),
                maxLeftPart + maxRightPart
        );
    }

    // O(N)

    int MSS_Kadane(List<Integer> array) {
        if (array.size() == 0) {
            return 0;
        }
        boolean allNegatives = true;
        int ans = Integer.MIN_VALUE;
        for (int i : array) {
            if (i >= 0) {
                allNegatives = false;
                break;
            } else if (i > ans) {
                ans = i;
            }
        }
        if (allNegatives) {
            return ans;
        }
        ans = 0;
        int sum = 0;
        for (int i : array) {
            sum += i;
            if (sum < 0) {
                sum = 0;
            } else if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }

    int MSS_V5(List<Integer> array) {
        if (array.size() == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : array) {
            if (sum > 0) {
                sum += i;
            } else {
                sum = i;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumContiguousSubarray instance = new MaxSumContiguousSubarray();
        List<Integer> list = Arrays.asList(2, 1, -3, 4, -1, 2, 1, -5, 4);
        List<Integer> list2 = Arrays.asList(-2, -1, -3, -4, -1, -2, -1, -5, -4);
        List<Integer> list3 = Arrays.asList(-100);

//        System.out.println(instance.maxSubArrayN3(list));
//        System.out.println(instance.maxSubArrayN2(list));
//        System.out.println(instance.MSS_divideAndConquer(list3, list3.size()));
//        System.out.println(instance.MSS_Kadane(list3));
        System.out.println(instance.MSS_V5(list));
    }
}
