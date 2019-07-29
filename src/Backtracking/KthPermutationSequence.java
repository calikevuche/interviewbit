package Backtracking;

import java.util.ArrayList;

public class KthPermutationSequence {

    private int step = 0;

    // --------------------------------//
    // WRONG ANSWER!
    // --------------------------------//

    public String getPermutation(int A, int B) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            arrayList.add(i + 1);
        }
        permutationHelper(A, B, 0, arrayList);
        return listToString(arrayList);
    }

    private boolean permutationHelper(int n, int k, int index, ArrayList<Integer> list) {
        if (step + 2 == k) {
            return true;
        }
        if (index > n - 1) {
            System.out.println("" + (step + 1) + " : " + listToString(list));
            step++;
            return false;
        }
        boolean res = permutationHelper(n, k, index + 1, list);
        if (res) {
            return true;
        }
        for (int i = index + 1; i < n; i++) {
            swap(list, i, index);
            res = permutationHelper(n, k, i, list);
            swap(list, i, index);
            if (res) {
                return true;
            }
        }
        return false;
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private String listToString(ArrayList<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer x: list) {
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }

    // --------------------------------//
    // Correct
    // --------------------------------//

    public String getPermutation2(int n, int k) {
        int[] numbers = new int[n];
        int[] indices = new int[n];

        // initialise the numbers 1, 2, 3...
        for (int i = 0; i < n; i++)
            numbers[i] = i + 1;

        int divisor = 1;
        for (int place = 1; place <= n; place++)
        {
            if(((k - 1) / divisor) == 0)
                break;  // all the remaining indices will be zero

            // compute the index at that place:
            indices[n-place] = ((k - 1) / divisor) % place;
            divisor *= place;
        }

        // permute the numbers array according to the indices:
        for (int i = 0; i < n; i++)
        {
            int index = indices[i] + i;

            // take the element at index and place it at i, moving the rest up
            if(index != i)
            {
                int temp = numbers[index];
                for(int j = index; j > i; j--)
                    numbers[j] = numbers[j-1];
                numbers[i] = temp;
            }
        }
        return arrayToString(numbers);
    }

    private String arrayToString(int[] ar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int x: ar) {
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }

    // --------------------------------//
    // InterviewBit
    // --------------------------------//

    public String getPermutation3(int n, int k) {
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candidates.add(i + 1);
        }
        return getPermutation3(k - 1, candidates);
    }

    private String getPermutation3(int k, ArrayList<Integer> candidates) {
        int n = candidates.size();
        if (n == 0) {
            return "";
        }
        if (k > factorial(n)) {
            return "";
        }
        int f = factorial(n - 1);
        int pos = k / f;
        k %= f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(candidates.remove(pos));
        stringBuilder.append(getPermutation3(k, candidates));
        return stringBuilder.toString();
    }

    private int factorial(int n) {
        if (n > 12) {
            return Integer.MAX_VALUE;
        }
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }


    public static void main(String[] args) {
        KthPermutationSequence ins = new KthPermutationSequence();
        System.out.println(ins.getPermutation3(3, 5));
    }
}