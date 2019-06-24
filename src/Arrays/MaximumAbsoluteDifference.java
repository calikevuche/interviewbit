package Arrays;

public class MaximumAbsoluteDifference {

    // O(N^2)
    public int maxArr(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int cur = Math.abs(A[i] - A[j]) + Math.abs(i - j);
                if (cur > result) {
                    result = cur;
                }
            }
        }
        return result;
    }

    // O(N)
    public int maxArr2(int[] A) {
        // case 1: A[i] + i; case 2: A[i] - i;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE,
                min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int temp1 = 0, temp2 = 0;
        for (int i = 0; i < A.length; i++) {
            temp1 = A[i] + i;
            temp2 = A[i] - i;
            if (temp1 > max1) {
                max1 = temp1;
            }
            if (temp1 < min1) {
                min1 = temp1;
            }
            if (temp2 > max2) {
                max2 = temp2;
            }
            if (temp2 < min2) {
                min2 = temp2;
            }
        }
        return Math.max(max1 - min1, max2 - min2);
    }
}
