package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 20.08.2016.
 */
public class Diffk {

    public int diffPossible1(ArrayList<Integer> a, int b) {
        for (int i = a.size()-1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                int diff = a.get(i) - a.get(j);
                if (diff == b) return 1;
                if (diff < b) break;
            }
        }
        return 0;
    }

    public int diffPossible(ArrayList<Integer> a, int b) {
        int j = 0;
        for (int i = 0; i < a.size() ; i++) {
            j = Math.max(j, i+1);
            while (j < a.size() && a.get(j) - a.get(i) < b) j++;
            if (j < a.size() && a.get(j) - a.get(i) == b) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Diffk instance = new Diffk();
//        System.out.println(instance.diffPossible(new ArrayList<>(Arrays.asList(1, 3, 5)), 4));
        System.out.println(instance.diffPossible(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4)), 0));
    }
}
