package Arrays;

import java.util.ArrayList;

/**
 * Created by OlehKa on 09.06.2016.
 */
public class PascalTriangleRows {

    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        if (a <= 0) return triangle;
        ArrayList<Integer> row;
        ArrayList<Integer> previousRow;
        for (int i = 0; i < a; i++) {
            row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
            } else if (i == 1) {
                row.add(1);
                row.add(1);
            } else {
                previousRow = triangle.get(i-1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) {
                        row.add(1);
                    } else if (j == i) {
                        row.add(1);
                    } else {
                        row.add(previousRow.get(j) + previousRow.get(j-1));
                    }

                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangleRows instance = new PascalTriangleRows();
        System.out.println(instance.generate(5));
    }
}
