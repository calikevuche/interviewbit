package DynamicProgramming;

public class SubMatricesWithSumZero {

    public int solve(int[][] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {

                for (int k = i; k < A.length; k++) {
                    for (int l = j; l < A[0].length; l++) {
                        if (isZeroSum(A, i, j, k + 1, l + 1)) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isZeroSum(int[][] matrix, int x0, int y0, int x1, int y1) {
        long sum = 0;
        for (int i = x0; i < x1; i++) {
            for (int j = y0; j < y1; j++) {
                sum += matrix[i][j];
            }
        }
        return sum == 0;
    }


    public int solve2(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int result = 0;
        int[] sumArray = new int[A[0].length];

        for (int i = 0; i < A.length; i++) {
            clearArray(sumArray);

            for (int j = i; j < A.length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    sumArray[k] += A[j][k];
                }
                result += getZeroSumNum(sumArray);
            }
        }
        return result;
    }

    private void clearArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    private int getZeroSumNum(int[] array) {
        int count = 0, temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                temp += array[j];
                if (temp == 0) {
                    count++;
                }
            }
            temp = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        SubMatricesWithSumZero ins = new SubMatricesWithSumZero();
        int t1 = ins.solve2(new int[][]{{-8, 5, 7}, {3, 7, -8}, {5, -8, 9}});
        System.out.println(t1);
    }
}
