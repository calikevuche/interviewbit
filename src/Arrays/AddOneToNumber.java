package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 09.06.2016.
 */
public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if (a.get(0) == 0) {
            int zeroNumber = 0;
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) == 0) {
                    zeroNumber = i + 1;
                } else {
                    break;
                }
            }
            if (zeroNumber == a.size()) {
                return new ArrayList<Integer>() {{
                    add(1);
                }};
            }
            a = new ArrayList<>(a.subList(zeroNumber, a.size()));
        }

        boolean stopFlag = false;
        int n = a.size() - 1;
        while (!stopFlag) {
            int value = a.get(n);
            if (value != 9) {
                a.set(n, ++value);
                stopFlag = true;
            } else {
                a.set(n, 0);
                if (n == 0) {
                    a.add(0, 1);
                    stopFlag = true;
                } else {
                    n--;
                }
            }
        }

        return a;
    }

    public static void main(String[] args) {
        AddOneToNumber instance = new AddOneToNumber();
        System.out.println(instance.plusOne(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println(instance.plusOne(new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9))));
        System.out.println(instance.plusOne(new ArrayList<>(Arrays.asList(0, 0, 1, 2, 3))));
        System.out.println(instance.plusOne(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0))));
        System.out.println(instance.plusOne(new ArrayList<>(Arrays.asList(0))));
    }
}
