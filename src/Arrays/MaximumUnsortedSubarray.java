package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnsortedSubarray {

    class MyComparator implements Comparator<Integer> {
        int[] array;

        MyComparator(int[] A) {
            array = A;
        }


        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(array[o1], array[o2]);
        }
    }

    public int[] subUnsort(int[] A) {
        Integer[] indices = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, new MyComparator(A));
        int minIndex = -1, maxIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (indices[i] != i) {
                if (minIndex == -1 || i < minIndex) {
                    minIndex = i;
                }
                if (maxIndex == -1 || i > maxIndex) {
                    maxIndex = i;
                }
            }
        }
        return minIndex == -1 ? new int[]{-1} : new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        MaximumUnsortedSubarray ins = new MaximumUnsortedSubarray();
        int[] testA = ins.subUnsort(new int[]{1, 3, 2, 4, 5});
        System.out.println(testA);
    }
}
