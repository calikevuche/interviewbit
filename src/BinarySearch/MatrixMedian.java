package BinarySearch;

import java.util.Arrays;

public class MatrixMedian {

    public int findMedian(int[][] A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int rows = A.length, cols = A[0].length;

        for (int i = 0; i < rows; i++) {
            if (A[i][0] < min) {
                min = A[i][0];
            }
            if (A[i][cols - 1] > max) {
                max = A[i][cols - 1];
            }
        }

        int desired = (rows * cols + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;

            for (int i = 0; i < rows; i++) {
                get = Arrays.binarySearch(A[i], mid);
                if (get < 0) {
                    get = Math.abs(get) - 1;
                } else {
                    while (get < A[i].length && A[i][get] == mid) {
                        get += 1;
                    }
                }
                place += get;
            }
            if (place < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int findMedian2(int[][] A) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (int) (left + ((long)right - left) / 2);
            int total = A.length * A[0].length;
            int smaller = countSmaller(A, mid);
            if (smaller > total / 2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int countSmaller(int[][] A, int x) {
        int smaller = 0;
        for (int i = 0; i < A.length; i++) {
            smaller += countSmaller(A[i], x);
        }
        return smaller;
    }

    private int countSmaller(int[] A, int x) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x <= A[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MatrixMedian ins = new MatrixMedian();
        int testA = ins.findMedian2(new int[][]{{1,3,5},{2,6,9},{3,6,9}});
        System.out.println(testA);
    }
}
