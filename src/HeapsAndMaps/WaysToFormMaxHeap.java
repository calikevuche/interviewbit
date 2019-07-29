package HeapsAndMaps;

public class WaysToFormMaxHeap {

    public int solve(int n) {
        if (n <= 1) {
            return 1;
        }
        int mod = 1000000007;

        int height = (int) (Math.log(n) / Math.log(2));
        int max = (int) Math.pow(2, height);
        int diff = n - max + 1;

        int left = (diff >= max/2) ? max - 1 :  max/2 + diff - 1;
        int right = n - left - 1;

        long combinations = combinations(left, n - 1, mod);
        long leftSide = solve(left);
        long rightSide = solve(right);

        return (int) ((((combinations * leftSide) % mod) * rightSide) % mod);
    }

    private long combinations(int m, int n, int mod) {
        int[] array = new int[m + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        array[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, m); j > 0; j--) {
                array[j] = (array[j] + array[j - 1]) % mod;
            }
        }

        return array[m];
    }

    public static void main(String[] args) {
        WaysToFormMaxHeap ins = new WaysToFormMaxHeap();
        System.out.println(ins.solve(4));
    }
}
