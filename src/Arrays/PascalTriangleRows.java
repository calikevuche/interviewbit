package Arrays;

import java.util.ArrayList;

/**
 * Created by OlehKa on 09.06.2016.
 */
public class PascalTriangleRows {

    public ArrayList<ArrayList<Integer>> getPascalTriangleV1(int a) {
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
                previousRow = triangle.get(i - 1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) {
                        row.add(1);
                    } else if (j == i) {
                        row.add(1);
                    } else {
                        row.add(previousRow.get(j) + previousRow.get(j - 1));
                    }

                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    // V2

    private ArrayList<Integer> generateList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(0);
        }
        return arrayList;
    }

    ArrayList<ArrayList<Integer>> getPascalTriangleV2(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (n <= 0) return result;
        for (int i = 1; i <= n; i++) {
            if (result.size() == 0) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(1);
                result.add(arrayList);
            } else {
                ArrayList<Integer> previous = result.get(i - 2);
                ArrayList<Integer> arrayList = generateList(i);
                int left = 0, right = i - 1, sum = 1;
                while (left <= right) {
                    if (left > 0) {
                        sum = previous.get(left) + previous.get(left - 1);
                    }
                    arrayList.set(left, sum);
                    arrayList.set(right, sum);
                    left++;
                    right--;
                }
                result.add(arrayList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangleRows instance = new PascalTriangleRows();
        System.out.println(instance.getPascalTriangleV2(5));
    }
}
