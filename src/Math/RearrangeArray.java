package Math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 19.06.2016.
 */
public class RearrangeArray {

    // **************** Recursive (BAD) solution ****************

    public void arrange0(ArrayList<Integer> a) {
        int positiveIndex = getPositiveIndex(a);
        while (positiveIndex != -1) {
            traverse(a, positiveIndex, a.get(positiveIndex));
            positiveIndex = getPositiveIndex(a);
        }

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == Integer.MIN_VALUE) {
                a.set(i, 0);
            }
            if (a.get(i) < 0) {
                a.set(i, (-1) * a.get(i));
            }
        }
    }

    void traverse(ArrayList<Integer> a, int index, int value) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == index) {
                int oldValue = a.get(i);
                a.set(i, value == 0 ? Integer.MIN_VALUE : (-1) * value);
                traverse(a, i, oldValue);
            }
        }
    }

    int getPositiveIndex(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) return i;
        }
        return -1;
    }

    // **************** Effective solution ****************

    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            int oldV = a.get(i);
            int newV = a.get(a.get(i)) % n;
            int element = oldV + newV * n; //coding
            a.set(i, element);
        }
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n); //decoding
        }
    }

    public static void main(String[] args) {
        RearrangeArray instance = new RearrangeArray();
//        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,0,0));
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,3,4,0,2));
        instance.arrange(arrayList);
        System.out.println(arrayList);
    }
}
