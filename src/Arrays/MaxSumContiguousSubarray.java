package Arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 29.05.2016.
 */
public class MaxSumContiguousSubarray {

    // DO NOT MODFIY THE LIST.
    public int maxSubArrayN3(final List<Integer> array) {
        if (array.size() == 0) return 0;
        int L = 0; int R = array.size() -1 ;
        int maxSum = array.get(0);
        int sum = 0;
        while (L <= R) {
            while (L <= R) {
                sum = 0;
                for (int j = L; j <= R; j++) {
                    sum = sum + array.get(j);
                }
                if (sum > maxSum) maxSum = sum;
                L++;
            }
            R--;
            L = 0;
        }
        return maxSum;
    }

    public int maxSubArrayN2(final List<Integer> array) {
        if (array.size() == 0) return 0;
        int L = 0; int R = 1;
        int maxSum = array.get(0);
        int sum = 0;
        while (L < array.size()) {
            sum = 0;
            while (R <= array.size()) {
                sum += array.get(R-1);
                if (sum > maxSum) maxSum = sum;
                R++;
            }
            L++;
            R = L + 1;
        }
        return maxSum;
    }

    int maxSubArrayConquer(List<Integer> array, int start, int end) {
        if (start == end) {
            return array.get(start);
        }
        int m = start + (end + 1 - start)/2;
        int leftMSA = maxSubArrayConquer(array, start, m-1);
        int rightMSA = maxSubArrayConquer(array, m, end);
        int maxLeftPart = Integer.MIN_VALUE;
        int maxRightPart = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = m; i <= end; i++) {
            sum += array.get(i);
            if (sum > maxRightPart) maxRightPart = sum;
        }
        sum = 0;
        for (int j = m-1; j >= start; j--) {
            sum += array.get(j);
            if (sum > maxLeftPart) maxLeftPart = sum;
        }
        return Math.max(Math.max(leftMSA, rightMSA), maxLeftPart + maxRightPart);
    }

    int maxSubArrayKadane(List<Integer> array) {
        if (array.size() == 0) return 0;
        if (array.size() == 1) return array.get(0);
        boolean isNegative = true;
        int maxNegative = Integer.MIN_VALUE;
        for(int num : array) {
            if (num >= 0) {
                isNegative = false;
                break;
            }
            else if (num > maxNegative) maxNegative = num;
        }
        if (isNegative) return maxNegative;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
            if (sum < 0) sum = 0;
            else if (sum > ans) ans = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSumContiguousSubarray instance = new MaxSumContiguousSubarray();
        List<Integer> list = Arrays.asList(2,-1,3,4,1,-2,1,-5,-4);
//        System.out.println(instance.maxSubArrayN3(list));
//        System.out.println(instance.maxSubArrayN2(list));
//        System.out.println(instance.maxSubArrayConquer(list, 0, list.size()-1));
        System.out.println(instance.maxSubArrayKadane(list));;
    }
}
