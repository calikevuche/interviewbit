package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 27.08.2016.
 */
public class MaxContinuousSeriesOf1s {

    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (i == 0 || a.get(i-1) != 1) {
                int end = i, counter = b;
                if (a.size() - i < result.size()) break;
                while (end < a.size()) {
                    if (a.get(end) == 0) {
                        counter--;
                        if (counter < 0) {
                            break;
                        }
                    }
                    end++;
                }
                if (end - i > result.size()) {
                    result.clear();
                    for (int j = i; j < end; j++) {
                        result.add(j);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxContinuousSeriesOf1s instance = new MaxContinuousSeriesOf1s();
        System.out.println(instance.maxone(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1 )), 1));
        System.out.println(instance.maxone(new ArrayList<>(Arrays.asList(0, 1, 1, 1  )), 0));
    }
}
