package Hashing;

import java.util.*;

public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Long, ArrayList<Integer>> hashMap = new HashMap<>();
        ArrayList<Integer> indexes, newList;

        int size = A.size(), first = 0, second = 0;
        long sum = 0L, target = B;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                sum = A.get(i) + A.get(j);
                if (hashMap.containsKey(target - sum)) {
                    indexes = hashMap.get(target - sum);
                    for (int k = 0; k < indexes.size(); k += 2) {
                        first = hashMap.get(target - sum).get(k);
                        second = hashMap.get(target - sum).get(k + 1);
                        if (first != i && first != j && second != i && second != j) {
                            newList = new ArrayList<>(
                                    Arrays.asList(A.get(first), A.get(second), A.get(i), A.get(j)));
                            Collections.sort(newList);
                            if (!contains(result, newList)) {
                                result.add(newList);
                            }
                        }
                    }
                }
                if (hashMap.containsKey(sum)) {
                    indexes = hashMap.get(sum);
                    indexes.add(i);
                    indexes.add(j);
                } else {
                    hashMap.put(sum, new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int res = Integer.compare(o1.get(0), o2.get(0));
                if (res != 0) {
                    return res;
                }
                res = Integer.compare(o1.get(1), o2.get(1));
                if (res != 0) {
                    return res;
                }
                res = Integer.compare(o1.get(2), o2.get(2));
                if (res != 0) {
                    return res;
                }
                res = Integer.compare(o1.get(3), o2.get(3));
                if (res != 0) {
                    return res;
                }
                return 0;
            }
        });
        return result;
    }

    private boolean contains(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        loop1:
        for (ArrayList<Integer> a : result) {
            if (a.size() != list.size()) {
                continue;
            }
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(list.get(i))) {
                    continue loop1;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FourSum instance = new FourSum();
        instance.fourSum(new ArrayList<>(Arrays.asList(
                9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2
        )), 0);
    }
}
