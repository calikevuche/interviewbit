package Bits;

import java.util.Arrays;

public class MinXorValue {

    // O(N^2)
    public int findMinXor(int[] A) {
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int xor = A[i] ^ A[j];
                if (xor < minXor) {
                    minXor = xor;
                }
            }
        }
        return minXor;
    }

    // O(N*logN)
    public int findMinXor2(int[] A) {
        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            int xor = A[i] ^ A[i + 1];
            if (xor < minXor) {
                minXor = xor;
            }
        }
        return minXor;
    }
}
