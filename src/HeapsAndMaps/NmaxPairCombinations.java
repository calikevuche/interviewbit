package HeapsAndMaps;

import java.util.*;

public class NmaxPairCombinations {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A.get(i) + B.get(j);
                int value = 0;
                if (treeMap.containsKey(sum)) {
                    value = treeMap.get(sum);
                }
                treeMap.put(sum, value + 1);
            }
        }
        for (Integer key : treeMap.descendingKeySet()) {
            for (int i = 0; i < treeMap.get(key); i++) {
                result.add(key);
                if (result.size() == n) {
                    return result;
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> solve2(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A.get(i) + B.get(j);
                if (priorityQueue.size() < n) {
                    priorityQueue.add(sum);
                } else {
                    if (priorityQueue.peek() < sum) {
                        priorityQueue.poll();
                        priorityQueue.add(sum);
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            result.add(priorityQueue.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        NmaxPairCombinations obj = new NmaxPairCombinations();
        obj.solve2(new ArrayList<>(Arrays.asList(1,4,2,3)), new ArrayList<>(Arrays.asList(2,5,1,6)));
    }
}
