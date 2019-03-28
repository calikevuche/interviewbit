package DynamicProgramming;

import java.util.Arrays;

public class LengthLongestSubsequence {

    // ver 1

    public int longestSubsequenceLength(final int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return 1;
        if (array.length == 2) return 2;
        return longestSubsequenceLength(array, 0);
    }

    private int longestSubsequenceLength(final int[] array, int limit) {
        if (array.length == 0) return 0;
        if (array.length == 1) return 1;
        if (array.length == 2) return 2;
        int max = getIncDecLength(array);
        if (array.length > limit + 1) {
            for (int i = 0; i < array.length; i++) {
                int cur = longestSubsequenceLength(removeElement(array, i), max);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }

    private int[] removeElement(int[] array, int pos) {
        int[] newArr = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i < pos) {
                newArr[i] = array[i];
            }
            if (i > pos) {
                newArr[i - 1] = array[i];
            }
        }
        return newArr;
    }

    private int getIncDecLength(int[] array) {
        int i = 0;
        while (i + 1 < array.length && array[i] < array[i + 1]) {
            i++;
        }
        while (i + 1 < array.length && array[i] > array[i + 1]) {
            i++;
        }
        return i + 1;
    }

    // ver 2

    public int longestSubsequenceLength2(final int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return 1;
        if (array.length == 2) return 2;

        int[] increment = new int[array.length];
        int[] decrement = new int[array.length];

        increment[0] = 1;
        for (int i = 1; i < array.length; i++) {
            increment[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (array[i] > array[j] && increment[i] < increment[j] + 1) {
                    increment[i] = increment[j] + 1;
                }
            }
        }

        decrement[array.length - 1] = 1;
        for (int i = array.length - 2; i >= 0; i--) {
            decrement[i] = 1;
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j] && decrement[i] < decrement[j] + 1) {
                    decrement[i] = decrement[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int max1 = increment[i] + decrement[i] - 1;
            if (max1 > max) {
                max = max1;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        LengthLongestSubsequence ins = new LengthLongestSubsequence();
//        int res = ins.longestSubsequenceLength2(new int[]{1, 11, 2, 10, 4, 5, 2, 1});
//        int res = ins.longestSubsequenceLength2(new int[]{9, 6, 1, 10, 2, 5, 12, 30, 31, 20, 22, 18});
        int res = ins.longestSubsequenceLength2(new int[]{148, 333, 306, 200, 397, 361, 458, 209, 4, 436, 282, 221, 358, 126, 235, 489, 444, 134, 42, 257, 240, 305, 480, 195, 102, 175, 44, 345, 224, 452, 249, 49, 173, 200, 241, 285, 438, -9, 132, 80, 238, 428, 463, 334, 399, 449, 242, 39, 56, 453, 108, 95, 492, 277, 109, 188, 376, 400, 265, 212, 304, 223, 321, 338, 120, 380, 74, 459, 277, 423, 176, 309, 465, 135, 170, 88, 11, 242, 305, 11, 19, 486, -7, 414, 442, 419, 3, 49, 201, 150, 127, 285, -5, 166, 320, 371, 12, 312, 267, 202, 360, 418, 481, 360, 409, 347, 139, 356, 277, 389, 212, 491, 272, 31, 206, 154, 265, 291, 174, 255, 398, 30, 360, 450, 432, 405, 244, 118, 320, 147, 277, 437, 495, 459, 273, 218, 197, 111, 449, 96, 236, 341, 496, 186, 61, 384, 123, 428, 492, 200, 389, 248, 95, 248, 74, 244, 300, 295, 264, 18, 278, 283, 51, 204, 0, 78, 333, 430, 168, 384, 402, 347, 406, 130, 64, 186, 339, 385, 458, 425, 120, 151, 402});
        System.out.println(res);
    }
}
