package DynamicProgramming;


import java.util.HashSet;
import java.util.Set;

public class LongestArithmeticProgression {

    // Time O(N^3)

    public int solve(final int[] array) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int diff = array[j] - array[i];
                if (!set.contains(diff)) {
                    set.add(diff);
                    result = Math.max(result, solve(array, diff, j));
                }
            }
        }
        return result + 1;
    }

    private int solve(final int[] array, int diff, int start) {
        int result = 1;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] - array[start] == diff) {
                result = solve(array, diff, i) + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestArithmeticProgression ins = new LongestArithmeticProgression();
        int t1 = ins.solve(new int[]{1,2,3});
        int t2 = ins.solve(new int[]{7,7,7});
        int t3 = ins.solve(new int[]{8,5,2});

        int t4 = ins.solve(new int[]{3,6,9,12});
        int t5 = ins.solve(new int[]{9,4,7,2,10});
        int t6 = ins.solve(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
    }
}
