package TwoPointers;

public class MinimizeTheAbsoluteDifference {

    public int solve(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        int min, max, temp;
        int result = Integer.MAX_VALUE;
        while (i < A.length && j < B.length && k < C.length) {
            min = Math.min(Math.min(A[i], B[j]), C[k]);
            max = Math.max(Math.max(A[i], B[j]), C[k]);
            temp = Math.abs(max - min);
            if (temp == 0) {
                return 0;
            }
            if (temp < result) {
                result = temp;
            }
            if (A[i] == min) {
                i++;
            } else if (B[j] == min) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimizeTheAbsoluteDifference ins = new MinimizeTheAbsoluteDifference();
        int testA = ins.solve(new int[]{1, 4, 5, 8, 10}, new int[]{6, 9, 15 }, new int[]{2, 3, 6, 6});
        System.out.println(testA);
    }
}
