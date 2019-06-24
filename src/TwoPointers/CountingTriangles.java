package TwoPointers;

import java.util.Arrays;

public class CountingTriangles {

    int M = 1000000007;

    public int nTriang(int[] A) {
        long count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    int max = Math.max(A[i], Math.max(A[j], A[k]));
                    long sum = (long) A[i] + A[j] + A[k];
                    if (sum - max > max) {
                        count++;
                        count %= M;
                    }
                }
            }
        }
        return (int) (count % M);
    }

    public int nTriang2(int[] A) {
        Arrays.sort(A);
        long count = 0;
        int left, right;
        long sum;
        for (int i = A.length - 1; i >= 0; i--) {
            left = 0;
            right = i - 1;
            while (left <= right) {
                sum = (long) A[left] + (long) A[right];
                if (sum > A[i]) {
                    count += (long) (right - left) % M;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return (int) (count % M);
    }

    public static void main(String[] args) {
        CountingTriangles ins = new CountingTriangles();
        int testA = ins.nTriang2(new int[]{4, 3, 6, 7});
        System.out.println(testA);
    }
}
