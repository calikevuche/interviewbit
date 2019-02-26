package DynamicProgramming;

import java.util.ArrayList;

public class JumpGameArray {

    public int canJump(int[] array) {
        int minIndex = array.length - 1;

        for (int i = array.length - 2; i >= 0; i--) {
            boolean possible = false;
            if (array[i] + i >= minIndex) {
                minIndex = i;
                possible = true;
            }
            if (i == 0) return possible ? 1 : 0;
        }
        return 1;
    }

    private int canJump1(int[] array, int pos, int[] cache) {
        if (array[pos] + pos >= array.length - 1) return 1;
        if (cache[pos] != 0) return 0;

        for (int i = 1; i < array[pos] + 1; i++) {
            int res = canJump1(array, pos + i, cache);
            if (res == 1) return 1;
        }
        cache[pos] = 1;
        return 0;
    }

    public int canJump2(int[] array) {
        int[] cache = new int[array.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = 0;
        }

        ArrayList<Integer> positions = new ArrayList<>();
        positions.add(0);

        while (!positions.isEmpty()) {
            int next = positions.remove(0);

            if (array[next] + next >= array.length - 1) return 1;
            if (cache[next] != 0) continue;

            for (int i = 1; i < array[next] + 1; i++) {
                if (cache[next + i] == 0) {
                    positions.add(next + i);
                }
            }
            cache[next] = 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        JumpGameArray ins = new JumpGameArray();
        int t1 = ins.canJump(new int[]{2, 3, 1, 1, 4}); //1
        int t2 = ins.canJump(new int[]{3, 2, 1, 0, 4}); //0
        int t3 = ins.canJump(new int[]{
                29, 0, 22, 30, 0, 7, 6, 0, 0, 0, 0, 7, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 9, 17, 7, 3, 27, 1, 17, 0, 0, 0, 0, 4, 0, 0, 0, 6, 17, 0, 0, 0, 0, 2, 0, 0, 0, 8, 0, 0, 0, 1, 13, 0, 19, 0, 0, 13, 0, 26, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 18, 0, 0, 7, 0, 6, 26, 3, 15, 0, 0, 6, 0, 25, 0, 0, 8, 0, 19, 0, 0, 0, 0, 1, 0, 26, 0, 0, 0, 26, 28, 14, 0, 0, 0, 14, 0, 0, 0, 0, 26, 0, 0, 0, 1, 0, 19, 0, 29, 9, 16, 14, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 23, 6, 0, 0, 8, 24, 0, 0, 0, 0, 11, 0, 26, 0, 19, 0, 5, 0, 29, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 10, 0, 4, 16, 29, 0, 0, 0, 0, 0, 0, 0, 21, 18, 17, 0, 0, 0, 0, 1, 0, 0, 10, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 0, 23, 0, 0, 14, 7, 24, 0, 0, 0, 0, 0, 0, 0, 29, 0, 8, 27, 0, 0, 0, 4, 0, 0, 0, 25, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 7, 29, 0, 0, 0, 1, 0, 4, 4, 17, 15, 0, 11, 15, 27, 23, 0, 0, 0, 2, 0, 15, 30, 26, 0, 0, 4, 0, 0, 21, 23, 0, 0, 0, 0, 19, 0, 0, 0, 0, 27, 14, 16, 0, 28, 0, 0, 0, 15, 0, 0, 7, 0, 0, 1, 0, 0, 30, 28, 0, 0, 2, 22, 20, 0, 0, 17, 8, 0, 0, 0, 11, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 27, 27, 9, 0, 7, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 19, 0, 4, 6, 2, 0, 0, 27, 19, 0, 14, 0, 0, 6, 0, 0, 0, 0, 0, 18, 0, 0, 0, 27, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 22, 5, 27, 24, 25, 0, 12, 0, 0, 26, 17, 5, 0, 0, 29, 21, 0, 0, 6, 3, 14, 0, 0, 0, 0, 0, 0, 11, 15, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 22, 0, 17, 22, 0, 0, 0, 1, 5, 20, 0, 0, 0, 22, 6, 21, 18, 0, 6, 7, 0, 1, 0, 0, 0, 18, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0
        }); //0
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
