package DynamicProgramming;

public class CoinsInALine {

    // wrong

    public int maxcoin(int[] A) {
        int resP1 = 0, resP2 = 0;
        int start = 0, end = A.length - 1;
        boolean myTurn = true;
        while (start <= end) {
            if (A[start] > A[end]) {
                if (myTurn) {
                    resP1 += A[start];
                } else {
                    resP2 += A[start];
                }
                start++;
            } else {
                if (myTurn) {
                    resP1 += A[end];
                } else {
                    resP2 += A[end];
                }
                end--;
            }
            myTurn = !myTurn;
        }
        return resP1 > resP2 ? resP1 : resP2;
    }


    public int maxcoin2(int[] A) {
        int max1 = getMax(A, 0, A.length - 1, true);
        int max2 = getMax(A, 0, A.length - 1, false);
        return max1 > max2 ? max1 : max2;
    }

    private int getMax(int[] A, int start, int end, boolean skip) {
        if (start > end) {
            return 0;
        }
        int max;
        if (skip) {
            if (A[start] > A[end]) {
                max = getMax(A, start + 1, end, false);
            } else {
                max = getMax(A, start, end - 1, false);
            }
        } else {
            if (A[start] > A[end]) {
                max = A[start] + getMax(A, start + 1, end, true);
            } else {
                max = A[end] + getMax(A, start, end - 1, true);
            }
        }
        return max;
    }

    // correct

    public int maxcoin3(int[] A) {
        int n = A.length;
        int[][][] dp = new int[2][n][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }

            }
        }
        return rec(dp, 0, 0, n - 1, A);
    }

    private int rec(int[][][] dp, int player, int start, int end, int[] vec) {
        if (start > end) {
            return 0;
        }
        if (dp[player][start][end] != -1) {
            return dp[player][start][end];
        }
        if (player == 0) {
            int ans = rec(dp, 1, start + 1, end, vec) + vec[start];
            ans = Math.max(ans, rec(dp, 1, start, end - 1, vec) + vec[end]);
            return dp[player][start][end] = ans;
        } else {
            return dp[player][start][end] = Math.min(
                    rec(dp, 0, start + 1, end, vec),
                    rec(dp, 0, start, end - 1, vec)
            );
        }
    }

    public int maxcoin4(int[] A) {
        int[][][] cache = new int[2][A.length][A.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < A.length; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return getMax(A, 0, A.length - 1, 0, cache);
    }

    private int getMax(int[] A, int start, int end, int player, int[][][] cache) {
        if (start > end) {
            return 0;
        }
        if (cache[player][start][end] != -1) {
            return cache[player][start][end];
        }
        int result;
        if (player == 1) {
            result = Math.min(
                    getMax(A, start + 1, end, 0, cache),
                    getMax(A, start, end - 1, 0, cache)
            );
        } else {
            result = Math.max(
                    A[start] + getMax(A, start + 1, end, 1, cache),
                    A[end] + getMax(A, start, end - 1, 1, cache)
            );
        }
        cache[player][start][end] = result;
        return result;
    }

    public static void main(String[] args) {
        CoinsInALine ins = new CoinsInALine();
        int t1 = ins.maxcoin2(new int[]{1, 2, 3, 4});
        System.out.println(t1);
        int t2 = ins.maxcoin2(new int[]{1, 100, 500, 10});
        System.out.println(t2);
    }
}
