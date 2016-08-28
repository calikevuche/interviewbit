package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 29.05.2016.
 */
public class MinStepsInfiniteGrid {

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int distance = 0;
        for (int i = 0; i < X.size() - 1; i++) {
            int x = X.get(i) - X.get(i+1);
            int y = Y.get(i) - Y.get(i+1);
            distance += max(modulus(x),modulus(y));
        }
        return distance;
    }

    public int max (int a, int b) {
        if (a > b) return a;
        else return b;
    }

    public int modulus(int a) {
        return a < 0 ? -a : a;
    }

    public static void main(String[] args) {
        MinStepsInfiniteGrid ins = new MinStepsInfiniteGrid();
        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(0,5,6));
        System.out.println(ins.coverPoints(X,Y));

    }
}
