package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class KthRowOfPascalsTriangle {

    // A - zero based
    public ArrayList<Integer> getRow(int A) {
        if (A <= 0) {
            return new ArrayList<>(Arrays.asList(1));
        }
        ArrayList<Integer> previous = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        previous.add(1);
        for (int i = 0; i < A; i++) {
            current.clear();
            current.add(1);
            int sum;
            for (int j = 0; j < previous.size() - 1; j++) {
                sum = previous.get(j) + previous.get(j + 1);
                current.add(sum);
            }
            current.add(1);
            previous.clear();
            previous.addAll(current);
        }
        return current;
    }

    public static void main(String[] args) {
        KthRowOfPascalsTriangle ins = new KthRowOfPascalsTriangle();
        System.out.println(ins.getRow(3));
    }
}
