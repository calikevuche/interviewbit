package Math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 27.06.2016.
 */
public class Prettyprint {

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        int size = 2 * a  - 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                arrayList.add(0);
            }
            result.add(arrayList);
        }
        int l = 0, r = size-1, b = size-1, t = 0;
        int number = a;
        while (l != r || b != t) {
            for (int i = l; i <= r; i++) {
                result.get(t).set(i, number);
            }
            for (int i = t; i <= b; i++) {
                result.get(i).set(r, number);
            }
            for (int i = r; i >= l; i--) {
                result.get(b).set(i, number);
            }
            for (int i = b; i >= t; i--) {
                result.get(i).set(l, number);
            }
            l++;
            r--;
            t++;
            b--;
            number--;
        }
        result.get(l).set(l, 1);

        return result;
    }

    public static void main(String[] args) {
        Prettyprint instance = new Prettyprint();
        System.out.println(instance.prettyPrint(4));
    }
}
