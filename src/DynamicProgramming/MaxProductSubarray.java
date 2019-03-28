package DynamicProgramming;

public class MaxProductSubarray {

    public int maxProduct(final int[] A) {
        int result = Integer.MIN_VALUE, temp = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                temp *= A[j];
                if (temp > result) {
                    result = temp;
                }
            }
            temp = 1;
        }
        return result;
    }

    public int maxProduct2(final int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        boolean checkZero = true;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] == 0) || (A[i] < 0 && (i == 0 || A[i - 1] == 0))) {
                continue;
            } else {
                checkZero = false;
                break;
            }
        }
        if (checkZero) {
            return 0;
        }
        int result = 0;
        int maxPositive = Integer.MIN_VALUE;
        int maxNegative = Integer.MAX_VALUE;
        int temp = 1, zeroIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (maxNegative < 0) {
                    for (int j = zeroIndex + 1; j < i; j++) {
                        maxNegative /= A[j];
                        if (A[j] < 0) {
                            break;
                        }
                    }
                    temp = maxPositive > maxNegative ? maxPositive : maxNegative;
                } else {
                    temp = maxPositive;
                }
                if (temp > result) {
                    result = temp;
                }
                temp = 1;
                zeroIndex = i;
                continue;
            }
            temp *= A[i];
            if (temp > 0 && temp > maxPositive) {
                maxPositive = temp;
            }
            if (temp < 0 && temp < maxNegative) {
                maxNegative = temp;
            }
        }
        if (maxNegative < 0) {
            for (int i = zeroIndex + 1; i < A.length; i++) {
                maxNegative /= A[i];
                if (A[i] < 0) {
                    break;
                }
            }
            temp = maxPositive > maxNegative ? maxPositive : maxNegative;
        } else {
            temp = maxPositive;
        }
        if (temp > result) {
            result = temp;
        }
        return result;
    }

    public int maxProduct3(final int[] A) {
        int min = 0, max = 0, temp = 0, result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(A[i], max * A[i]);
            min = Math.min(A[i], min * A[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProductSubarray ins = new MaxProductSubarray();
        int t1 = ins.maxProduct3(new int[]{2, 3, -2, 4});
        System.out.println(t1);
        int t2 = ins.maxProduct3(new int[]{-4, 0, -5, 0});
        System.out.println(t2);
    }
}
