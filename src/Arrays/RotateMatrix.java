package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 10.06.2016.
 */
public class RotateMatrix {

    public void rotateBruteForce(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arrayList.add(0);
            }
            b.add(arrayList);
        }
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                b.get(j).set(n - 1 - i, a.get(i).get(j));
            }
        }
        a.clear();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arrayList.add(b.get(i).get(j));
            }
            a.add(arrayList);
        }
        System.out.println(a);
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a == null) return;
        int n = a.size();
        if (n == 0) return;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n-i-1; j++) {

                // right
                int value = a.get(i).get(j);
                int temp = a.get(j).get(n-i-1);
                a.get(j).set(n-i-1, value);

                // down
                value = temp;
                temp = a.get(n-i-1).get(n-j-1);
                a.get(n-i-1).set(n-j-1, value);

                // left
                value = temp;
                temp = a.get(n-j-1).get(i);
                a.get(n-j-1).set(i, value);

                // up
                value = temp;
                a.get(i).set(j, value);
            }
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        RotateMatrix instance = new RotateMatrix();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        list.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        list.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
        list.add(new ArrayList<>(Arrays.asList(13,14,15,16)));
        instance.rotate(list);
    }
}
