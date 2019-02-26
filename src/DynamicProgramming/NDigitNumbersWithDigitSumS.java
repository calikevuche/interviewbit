package DynamicProgramming;

public class NDigitNumbersWithDigitSumS {

    public int solve(int N, int S) {
        int [][] cache = new int[N + 1][S + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < S + 1; j++) {
                cache[i][j] = 0;
            }
        }
        return solve(N, S, false, cache);
    }

    private int solve(int N, int S, boolean hasZero, int [][] cache) {
        if (S < 0 || S > 9 * N) {
            return 0;
        }
        if (N == 0) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (cache[N][S] != 0) {
            return cache[N][S];
        }

        int result = 0;
        for (int i = hasZero ? 0 : 1; i <= 9; i++) {
            result += solve(N - 1, S - i, true, cache);
            result %= 1000000007;
        }
        cache[N][S] = result;
        return result;
    }


    public static void main(String[] args) {
        NDigitNumbersWithDigitSumS ins = new NDigitNumbersWithDigitSumS();
        int t1 = ins.solve(2, 4);
        int t3 = ins.solve(160, 400);
        System.out.println(t1);
        System.out.println(t3);
    }
}
