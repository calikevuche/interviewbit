package DynamicProgramming;

public class MaxSumWithoutAdjacentElements {

    // 2 * N
    public int adjacent(int[][] A) {
        int N = A[0].length;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Math.max(A[0][i], A[1][i]);
        }
        int[] cache = new int[N];
        for (int i = 0; i < N; i++) {
            cache[i] = -1;
        }
        return getMaxSum(array, 0, cache);
    }

    private int getMaxSum(int[] array, int index, int[] cache) {
        if (index > array.length - 1) {
            return 0;
        }
        if (cache[index] != -1) {
            return cache[index];
        }
        int sum1 = getMaxSum(array, index + 2, cache) + array[index];
        if (index == array.length - 1) {
            cache[index] = sum1;
            return sum1;
        }
        int sum2 = getMaxSum(array, index + 3, cache) + array[index + 1];
        int result = Math.max(sum1, sum2);
        cache[index] = result;
        return result;
    }

    // 2 * N
    public int adjacent2(int[][] A) {
        int N = A[0].length;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Math.max(A[0][i], A[1][i]);
        }
        // include element: 0 - false, 1 - true
        int[][] cache = new int[2][N];
        cache[0][0] = 0;
        cache[1][0] = array[0];
        for (int i = 1; i < N; i++) {
            cache[0][i] = Math.max(cache[0][i - 1], cache[1][i - 1]);
            cache[1][i] = cache[0][i - 1] + array[i];
        }
        return Math.max(cache[0][N - 1], cache[1][N - 1]);
    }

    public static void main(String[] args) {
        MaxSumWithoutAdjacentElements ins = new MaxSumWithoutAdjacentElements();
        int t1 = ins.adjacent2(new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}});
        int t2 = ins.adjacent2(new int[][]{{16, 5, 54, 55, 36, 82, 61, 77, 66, 61}, {31, 30, 36, 70, 9, 37, 1, 11, 68, 14}});
        System.out.println(t1);
        System.out.println(t2);
    }
}
