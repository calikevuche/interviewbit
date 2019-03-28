package DynamicProgramming;

public class TusharsBirthdayParty {

    // A - friends, B - capacity, C - cost
    public int solve(final int[] A, final int[] B, final int[] C) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            Friend f = new Friend(A[i], 0, Integer.MAX_VALUE);
            getMinCost(B, C, f);
            result += f.min;
        }
        return result;
    }

    // A - friends, B - capacity, C - cost
    public int solve2(final int[] A, final int[] B, final int[] C) {
        int[] cache = new int[1001];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += getMinCost(B, C, cache, A[i]);
        }
        return result;
    }

    // A - friends, B - capacity, C - cost
    public int solve3(final int[] A, final int[] B, final int[] C) {
        int[][] cache = new int[1001][1001];

        int maxA = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > maxA) {
                maxA = A[i];
            }
        }

        // i - capacity, j - dish
        for (int i = 0; i < maxA + 1; i++) {
            for (int j = 0; j < B.length + 1; j++) {
                if (i == 0) {
                    cache[i][j] = 0;
                } else if (j == 0) {
                    cache[i][j] = Integer.MAX_VALUE / 2;
                } else {
                    if (i >= B[j - 1]) {
                        cache[i][j] = Math.min(cache[i][j - 1], cache[i - B[j - 1]][j] + C[j - 1]);
                    } else {
                        cache[i][j] = cache[i][j - 1];
                    }
                }
            }
        }
        // cache[i][j] holds minCost of friend (i) using first (j) dishes
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += cache[A[i]][B.length];
        }
        return result;
    }

    private void getMinCost(int[] B, int[] C, Friend friend) {
        if (friend.sum == 0) {
            if (friend.cur < friend.min) {
                friend.min = friend.cur;
            }
            return;
        }
        if (friend.sum < 0) {
            return;
        }
        for (int i = 0; i < B.length; i++) {
            friend.sum -= B[i];
            friend.cur += C[i];
            getMinCost(B, C, friend);
            friend.sum += B[i];
            friend.cur -= C[i];
        }
    }

    private int getMinCost(int[] B, int[] C, int[] cache, int sum) {
        if (sum < 0) {
            return -1;
        }
        if (sum == 0) {
            return 0;
        }
        if (cache[sum] != -1) {
            return cache[sum];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < B.length; i++) {
            int cur = getMinCost(B, C, cache, sum - B[i]);
            if (cur != -1) {
                cur += C[i];
                if (cur < min) {
                    min = cur;
                }
            }
        }
        cache[sum] = min;
        return min;
    }

    class Friend {

        int sum;
        int cur;
        int min;

        Friend(int sum, int cur, int min) {
            this.sum = sum;
            this.cur = cur;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        TusharsBirthdayParty ins = new TusharsBirthdayParty();
        int t1 = ins.solve3(new int[]{4, 6}, new int[]{1, 3}, new int[]{5, 3});
        System.out.println(t1);
    }
}
