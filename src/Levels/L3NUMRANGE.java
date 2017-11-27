package Levels;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 01.09.2016.
 */
public class L3Numrange {

    public int numRange(ArrayList<Integer> a, int b, int c) {
        int counter = 0;
        for (int i = 0; i < a.size(); i++) {
            int sum = 0;
            for (int j = i; j < a.size(); j++) {
                sum += a.get(j);
                if (sum >= b && sum <= c) counter++;
                else if (sum > c) break;
            }
            if (sum < b) break;
        }
        return counter;
    }

    public static void main(String[] args) {
        L3Numrange instance = new L3Numrange();
        System.out.println(instance.numRange(new ArrayList<>(Arrays.asList(10, 5, 1, 0, 2)), 6, 8));
    }
}
