package DynamicProgramming;

public class BestTimeToBuyAndSellStocksII {

    public int maxProfit(final int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int result = 0, bottom = 0, top = 0;
        boolean buy = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (i == 0) {
                bottom = A[0];
            }
            if (buy) {
                if (A[i + 1] < bottom) {
                    bottom = A[i + 1];
                }
                if (A[i + 1] > bottom) {
                    top = A[i + 1];
                    buy = !buy;
                }
            } else {
                if (A[i + 1] > top) {
                    top = A[i + 1];
                }
                if (A[i + 1] < top) {
                    result += top - bottom;
                    bottom = A[i + 1];
                    buy = !buy;
                }
            }
        }
        if (!buy) {
            result += top - bottom;
        }
        return result;
    }
}
