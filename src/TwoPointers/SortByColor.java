package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 24.08.2016.
 */
public class SortByColor {

    public void sortColors1(ArrayList<Integer> a) {
        int red = 0; // 0
        int white = 0; // 1
        int blue = 0; // 2
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == 0) {
                a.add(red, a.get(i));
                a.remove(i + 1);
                red++;
            } else if (a.get(i) == 1) {
                a.add(red + white, a.get(i));
                a.remove(i + 1);
                white++;
            } else if (a.get(i) == 2) {
                a.add(red + white + blue, a.get(i));
                a.remove(i + 1);
                blue++;
            }
        }
        System.out.println(a);
    }

    public void sortColors2(ArrayList<Integer> a) {
        int red = 0; // 0
        int white = 0; // 1
        int blue = 0; // 2
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == 0) {
                red++;
            } else if (a.get(i) == 1) {
                white++;
            } else if (a.get(i) == 2) {
                blue++;
            }
        }
        a.clear();
        for (int i = 0; i < red; i++) {
            a.add(0);
        }
        for (int i = 0; i < white; i++) {
            a.add(1);
        }
        for (int i = 0; i < blue; i++) {
            a.add(2);
        }
        System.out.println(a);
    }

    public void sortColors(ArrayList<Integer> a) {
        int zero = 0;
        int two = a.size() - 1;

        for (int i = 0; i <= two; ) {
            if (a.get(i) == 0) {
                int temp = a.get(zero);
                a.set(zero, 0);
                a.set(i, temp);
                zero++;
                i++;
            } else if (a.get(i) == 2) {
                int temp = a.get(two);
                a.set(two, 2);
                a.set(i, temp);
                two--;
            } else {
                i++;
            }
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        SortByColor instance = new SortByColor();
        instance.sortColors(new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2)));
        instance.sortColors(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 2, 0, 0, 0, 1, 2, 2, 2, 2, 0, 1)));
        instance.sortColors(new ArrayList<>(Arrays.asList()));
    }
}
