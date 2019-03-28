package DynamicProgramming;


public class FlipArray {

    public int solve(final int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        Node node = solve(A, sum, 0);
        return node == null ? 0 : node.items;
    }

    private Node solve(int[] A, int sum, int number) {
        if (sum < 0) {
            return null;
        }
        if (sum == 0) {
            return new Node(number, 0);
        }
        Node minRes = new Node(number, sum), tempRes = null;
        int val = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                continue;
            }
            val = A[i];
            A[i] = -1 * val;
            tempRes = solve(A, sum - 2 * val, number + 1);
            A[i] = val;
            if (tempRes == null) {
                continue;
            }
            if (tempRes.weight < minRes.weight ||
                    tempRes.items < minRes.items) {
                minRes = tempRes;
            }
        }
        return minRes;
    }

    public int solve2(final int[] A) {
        int maxN = 105, maxS = 10005;
        Node[][] dp = new Node[maxN][maxS];
        int n = A.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        sum /= 2;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = new Node(0, 0);
                } else {
                    int prevItems = dp[i - 1][j].items;
                    int prevWeight = dp[i - 1][j].weight;

                    if (j - A[i - 1] >= 0) {
                        int curWeight = dp[i - 1][j - A[i - 1]].weight + A[i - 1];
                        int curItems = dp[i - 1][j - A[i - 1]].items + 1;
                        if (curWeight > prevWeight ||
                                (curWeight == prevWeight && curItems < prevItems)) {
                            dp[i][j] = new Node(curItems, curWeight);
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][sum].items;
    }


    public static void main(String[] args) {
        FlipArray ins = new FlipArray();
//        int t1 = ins.solve(new int[]{15, 10, 6});
//        int t2 = ins.solve(new int[]{14, 10, 4});
        int t3 = ins.solve(new int[]{5, 4, 6, 8, 7, 2, 3});
//        System.out.println(t1);
//        System.out.println(t2);
        System.out.println(t3);
    }

    class Node {

        int items = 0;
        int weight = 0;

        public Node(int items, int weight) {
            this.items = items;
            this.weight = weight;
        }
    }
}