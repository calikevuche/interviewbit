package DynamicProgramming;

public class BestTimeToBuyAndSellStocksI {

    public int maxProfit(final int[] A) {
        int result = 0, temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = maxProfit(A, i) - A[i];
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    private int maxProfit(final int[] A, int start) {
        int max = A[start];
        for (int i = start + 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public int maxProfit2(final int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int result = 0, max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            if (max - A[i] > result) {
                result = max - A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        return result;
    }
}
