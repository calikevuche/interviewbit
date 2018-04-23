package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by OlehKa on 11.06.2016.
 */
public class RepeatMissingNumberArray {

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> repeatedNumber1(final List<Integer> in) {
        ArrayList<Integer> result = new ArrayList<>();
        int A = 0, B = 0; // repeat and missing

        List<Integer> list = new ArrayList<>(in);

        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i) - 1;
            if (!Objects.equals(list.get(j), list.get(i))) {
                int temp = list.get(j);
                list.set(j, list.get(i));
                list.set(i, temp);
                i--;
            } else if (i != j) {
                A = list.get(i);
                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != i + 1) {
                B = i + 1;
                break;
            }
        }

        result.add(A);
        result.add(B);

        return result;
    }

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> repeatedNumber2(final List<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        double A = 0, B = 0; // repeat and missing

        // RealSum(a) = Sum(1..n) + A - B
        // RealSquareSum(a) = SquareSum(1..n) + A^2 - B^2

        long sum = 0;
        long squares = 0;

        for (int i = 0; i < a.size(); i++) {
            int value = a.get(i);
            sum += value;
            sum -= i + 1;
            squares += (long) value * (long) value;
            squares -= (long) (i + 1) * (long) (i + 1);
        }

        A = 0.5 * (sum + squares / sum);
        B = squares / sum - A;

        result.add((int) A);
        result.add((int) B);
        return result;
    }

    public static void main(String[] args) {
        RepeatMissingNumberArray instance = new RepeatMissingNumberArray();
        List<Integer> list = Arrays.asList(3,1,2,5,3);
        System.out.println(list);
        System.out.println(instance.repeatedNumber2(list));
    }
}
