package Graphs;

import java.util.TreeSet;

public class SmallestSequenceWithGivenPrimes {

    // O(N * logN)
    public int[] solve0(int A, int B, int C, int D) {
        int[] result = new int[D];
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(A);
        treeSet.add(B);
        treeSet.add(C);

        for (int i = 0; i < D; i++) {
            int min = treeSet.first();
            result[i] = min;
            treeSet.remove(min);
            treeSet.add(min * A);
            treeSet.add(min * B);
            treeSet.add(min * C);
        }
        return result;
    }

    // O(N)
    public int[] solve1(int A, int B, int C, int D) {
        int[] result = new int[D];
        int[] initialSet = new int[3];
        int[] indexInFinalSet = new int[3];

        initialSet[0] = A;
        initialSet[1] = B;
        initialSet[2] = C;

        for (int i = 0; i < D; i++) {
            int minId = getMinIndex(initialSet);
            if (i > 0 && result[i - 1] == initialSet[minId]) {
                i--;
            } else {
                result[i] = initialSet[minId];
            }
            if (minId == 0) {
                initialSet[0] = result[indexInFinalSet[0]] * A;
                indexInFinalSet[0] += 1;
            } else if (minId == 1) {
                initialSet[1] = result[indexInFinalSet[1]] * B;
                indexInFinalSet[1] += 1;
            } else {
                initialSet[2] = result[indexInFinalSet[2]] * C;
                indexInFinalSet[2] += 1;
            }
        }
        return result;
    }

    private int getMinIndex(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        int minId = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[minId]) {
                minId = i;
            }
        }
        return minId;
    }

    public static void main(String[] args) {
        SmallestSequenceWithGivenPrimes instance = new SmallestSequenceWithGivenPrimes();
        instance.solve1(2, 3, 5, 6);
    }
}
