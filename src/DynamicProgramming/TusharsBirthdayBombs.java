package DynamicProgramming;

import java.util.*;

public class TusharsBirthdayBombs {

    //v1

    public int[] solve(int A, int[] B) {
        List<Integer> result = new ArrayList<Integer>();
        solve(A, B, new ArrayList<Integer>(), result);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private void solve(int A, int[] B, List<Integer> list, List<Integer> result) {
        if (A < 0) {
            return;
        }
        if (list.size() > result.size() ||
                (list.size() == result.size() && smaller(list, result))
        ) {
            result.clear();
            result.addAll(list);
        }
        for (int i = 0; i < B.length; i++) {
            list.add(i);
            solve(A - B[i], B, list, result);
            list.remove(list.size() - 1);
        }
    }

    private boolean smaller(List<Integer> test, List<Integer> result) {
        if (test.size() != result.size()) {
            return false;
        }
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i) < result.get(i)) {
                return true;
            }
            if (test.get(i) > result.get(i)) {
                return false;
            }
        }
        return false;
    }

    //v2

    public int[] solve2(int A, int[] B) {
        int minElement = B[0];
        int endIndex = 0;
        for (int i = 1; i < B.length; i++) {
            if (B[i] < minElement) {
                minElement = B[i];
                endIndex = i;
            }
        }
        int size = A / minElement;
        List<Integer> resultList = solve2(A, B, size, endIndex, minElement, new HashMap<Integer, List<Integer>>(), new ArrayList<Integer>());
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    private List<Integer> solve2(int A, int[] B, int size, int endIndex, int minElement,
                                 Map<Integer, List<Integer>> cache, List<Integer> list) {
        if (size == 0) {
            return list;
        }
        if (cache.containsKey(A)) {
            return cache.get(A);
        }
        List<Integer> result = new ArrayList<>(), temp;
        for (int i = 0; i <= endIndex; i++) {
            if (B[i] + (size - 1) * minElement <= A) {
                list.add(i);
                temp = solve2(A - B[i], B, size - 1, endIndex, minElement, cache, list);
                if (result.isEmpty() || smaller(temp, result)) {
                    result.clear();
                    result.addAll(temp);
                }
                list.remove(list.size() - 1);
            }
        }
        cache.put(A, result);
        return result;
    }

    // v3

    public int[] solve3(int A, int[] B) {
        int minElement = B[0];
        int minIndex = 0;
        for (int i = 1; i < B.length; i++) {
            if (B[i] < minElement) {
                minElement = B[i];
                minIndex = i;
            }
        }
        int size = A / minElement;
        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = minIndex;
        }
        int sum = minElement * size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < minIndex + 1; j++) {
                if (B[j] - minElement + sum <= A) {
                    resultArray[i] = j;
                    sum -= minElement;
                    sum += B[j];
                    break;
                }
            }
        }
        return resultArray;
    }


    public static void main(String[] args) {
        TusharsBirthdayBombs ins = new TusharsBirthdayBombs();
        int[] t1 = ins.solve3(11, new int[]{6, 8, 5, 4, 7});
        System.out.println(Arrays.toString(t1));
        int[] t2 = ins.solve3(10, new int[]{8, 8, 6, 5, 4});
        System.out.println(Arrays.toString(t2));
    }
}
