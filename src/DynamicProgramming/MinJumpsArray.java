package DynamicProgramming;

import java.util.ArrayList;

public class MinJumpsArray {

    public int jump(int[] array) {
        int[] cache = new int[array.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = 0;
        }
        return jump(array, 0, cache);
    }

    // slow
    private int jump(int[] array, int pos, int[] cache) {
        if (pos + array[pos] >= array.length - 1) return 1;
//        if (cache[pos] != 0) return cache[pos];

        int result = -1;
        for (int i = 1; i < array[pos] + 1; i++) {
            int temp = jump(array, pos + i, cache) + 1;
            if (result == -1 || temp < result) {
                result = temp;
            }
        }

        cache[pos] = result;
        return result;
    }

    // wrong
    public int jump2(int[] array) {
        int[] distances = new int[array.length];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = 0;
        }

        int steps = 0, maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] + i >= array.length - 1) {
                return steps;
            }

            if (distances[i] == 0) {
                distances[i] = steps;
            }
            for (int j = 1; j < array[i] + 1; j++) {
                if (i + j > maxIndex) {
                    maxIndex = array[i] + i;
                    steps++;
                }
                if (distances[i + j] == 0) {
                    distances[i + j] = steps;
                }
            }
        }

        return -1;
    }

    // correct
    public int jump3(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        int maxReachPos = array[0];
        int curMaxReachPos = array[0];
        int curStep = 1;

        for (int i = 1; i <= maxReachPos; i++) {
            if (i == array.length - 1) {
                return curStep;
            }
            curMaxReachPos = Math.max(curMaxReachPos, array[i] + i);
            if (i == maxReachPos) {
                if (curMaxReachPos <= i) {
                    return -1;
                }
                maxReachPos = curMaxReachPos;
                curStep++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinJumpsArray minJumpsArray = new MinJumpsArray();
        int t1 = minJumpsArray.jump(new int[]{2, 3, 1, 1, 4}); // 2
        int t2 = minJumpsArray.jump(new int[]{2, 3, 1, 1, 4, 2, 3, 1, 1, 4}); // 4
        int t3 = minJumpsArray.jump3(new int[]{
                33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28
        }); // 3
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
