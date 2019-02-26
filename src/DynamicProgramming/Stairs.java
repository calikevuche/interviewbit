package DynamicProgramming;

public class Stairs {

    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        memo[0] = 1;
        memo[1] = 1;
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int[] memo) {
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];
        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        int result = stairs.climbStairs(4);
        System.out.println(result);
    }
}
