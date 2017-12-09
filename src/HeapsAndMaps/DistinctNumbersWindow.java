package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class DistinctNumbersWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (B > A.size()) {
            return result;
        } else {
            // we can use HashMap<Integer, Integer> key = A.get(i), value = counter_of_key
            TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
            for (int i = 0; i < B; i++) {
                addToMap(treeMap, A.get(i), i);
            }
            result.add(treeMap.size());
            for (int i = B; i < A.size(); i++) {
                int removedValue = i - B;
                int removedKey = A.get(removedValue);
                treeMap.get(removedKey).remove(Integer.valueOf(removedValue));
                if (treeMap.get(removedKey).size() == 0) {
                    treeMap.remove(removedKey);
                }
                addToMap(treeMap, A.get(i), i);
                result.add(treeMap.size());
            }
            return result;
        }
    }

    private void addToMap(TreeMap<Integer, ArrayList<Integer>> treeMap, int key, int value) {
        if (treeMap.containsKey(key)) {
            treeMap.get(key).add(value);
        } else {
            treeMap.put(key, new ArrayList<>(Collections.singletonList(value)));
        }
    }

    public static void main(String[] args) {
        DistinctNumbersWindow instance = new DistinctNumbersWindow();
        instance.dNums(new ArrayList<>(Arrays.asList(1,2,1,3,4,3)), 3);
    }
}
