package TwoPointers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 24.08.2016.
 */
public class RemoveElementFromArray {

    public int removeElement1(ArrayList<Integer> a, int b) {
        if (a.size() == 0) return 0;
        int index = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b && index == -1) {
                index = i;
            }
            if (a.get(i) != b) {
                if (index != -1) {
                    int temp = a.get(i);
                    a.set(i, b);
                    a.set(index, temp);
                    i = index;
                    index = -1;
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b) return i;
        }
        return a.size();
    }

    //better solution
    public int removeElement(ArrayList<Integer> a, int b) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b) continue;
            else {
                a.set(count, a.get(i));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveElementFromArray instance = new RemoveElementFromArray();
//        instance.removeElement(new ArrayList<>(Arrays.asList(4,1,1,2,1,3)), 1);
//        instance.removeElement(new ArrayList<>(Arrays.asList(0)), 0);
//        instance.removeElement(new ArrayList<>(Arrays.asList(1, 3, 3, 2, 1)), 0);
//        instance.removeElement(new ArrayList<>(Arrays.asList(2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2 )), 2);
//        instance.removeElement(new ArrayList<>(Arrays.asList(2, 2, 0, 3, 2, 1, 0, 1, 2, 1, 3, 0, 2, 1, 3, 0, 3, 0, 1, 3, 2, 1, 2, 1, 1, 3, 3, 2, 0, 2, 1, 0, 2, 1, 1, 3, 0, 2, 3, 1, 1, 2, 3, 0, 2, 0, 2, 0, 1, 1, 1, 2, 3, 1, 3, 0, 1, 3, 1, 1, 2, 1, 0, 3, 0, 0, 1, 1, 0, 3, 3, 3, 3, 1, 0, 0, 3, 0, 1, 3, 2, 3, 1, 3, 1, 1, 1, 0, 1, 0, 2, 2, 1, 1, 3, 0, 2, 3, 3, 0, 0, 2, 2, 3, 2, 1, 0, 0, 1, 2, 2, 1, 1, 1, 0, 2, 0, 1, 3, 3, 1, 2, 1, 2, 1, 2, 3, 0, 2, 2, 1, 1, 3, 2, 1, 0, 3, 0, 3, 3, 2, 1, 2, 0, 3, 2, 3, 3, 1, 3, 0, 3, 2, 0, 0, 3, 2, 3, 1, 3, 3, 2, 3, 3, 2, 0, 1, 0, 2, 2, 2, 1, 1, 0, 3, 3, 2, 2, 3, 0, 3, 3, 2, 2, 0, 2, 2, 2, 1, 0, 2, 2, 0, 1, 3, 3, 0, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 0, 1, 2, 1, 2, 3, 3, 2, 0, 3, 2, 0, 2, 0, 1, 2, 0, 1, 0, 0, 0, 2, 1, 3, 0, 1, 0, 1, 1, 2, 0, 0, 2, 0, 3, 0, 2, 1, 2, 3, 0, 0, 2, 3, 3, 1, 0, 1, 1, 2, 1, 1, 2, 0, 2, 0, 1, 2, 1, 0, 2, 2, 0, 3, 3, 1, 3, 0, 0, 0, 2, 3, 3, 2, 1, 3, 2, 0, 3, 0, 0, 1, 0, 2, 0, 3, 1, 0, 1, 1, 1, 1, 2, 3, 3, 3, 1, 0, 0, 1, 2, 0, 2, 1, 2, 2, 2, 2, 0, 1, 1, 2, 2, 1, 1, 1, 0, 3, 3, 1, 2, 2, 3, 3, 3, 1, 3, 1, 2, 3, 1, 1, 3, 3, 1, 3, 3, 2, 0, 3, 0, 2, 3, 3, 0, 3, 0, 2, 3, 0, 0, 1, 1, 2, 1, 3, 1, 1, 1, 2, 1, 0, 3, 1, 2, 0, 2, 2, 3, 0, 1, 0, 1, 1, 3, 2, 3, 3 )), 1);
        instance.removeElement(new ArrayList<>(Arrays.asList(2, 1, 1, 2, 1, 1, 2, 0, 3, 2, 1, 1, 3, 3, 3, 1, 2, 1, 3, 3, 2)), 0);

    }
}
