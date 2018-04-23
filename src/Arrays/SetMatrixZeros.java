package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 01.06.2016.
 */
public class SetMatrixZeros {

    public void setZeroesV1(ArrayList<ArrayList<Integer>> a) {
        int n = a.size(); // rows count
        int m = a.get(0).size(); // columns count
        ArrayList<Integer> MN = new ArrayList<>();
        for (int k = 0; k < m + n; k++) {
            MN.add(k, 1);
        }
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    MN.set(i, 0);
                    MN.set(n + j, 0);
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (MN.get(i) == 0 || MN.get(n + j) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }
        System.out.println(a);
    }

    public void setZeroesV2(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0 || a.get(0).size() == 0) {
            return;
        }
        int m = a.size(); // rows count
        int n = a.get(0).size(); // columns count
        boolean firstRowZero = false, firstColumnZero = false;

        for (int i = 0; i < n; i++) {
            if (a.get(0).get(i) == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (a.get(i).get(0) == 0) {
                firstColumnZero = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(0, 0); // row
                    a.get(0).set(j, 0); // column
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < n; i++) {
                a.get(0).set(i, 0);
            }
        }
        if (firstColumnZero) {
            for (int i = 0; i < m; i++) {
                a.get(i).set(0, 0);
            }
        }
        System.out.println(a);
    }

    public void setZeroesV3(ArrayList<ArrayList<Integer>> A) {
        int m, n;

        if (A == null)
            return;

        m = A.size();
        n = A.get(0).size();

        if (n == 0)
            return;

        for (int i = 0; i < m; i++) {
            boolean zero = false;
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 0)
                    zero = true;
            }

            if (zero)
                clearRow(A, i, m, n, 2);

        }

        for (int i = 0; i < n; i++) {
            boolean zero = false;
            for (int j = 0; j < m; j++) {
                if (A.get(j).get(i) == 0)
                    zero = true;
            }

            if (zero)
                clearCol(A, i, m, n, 2);

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 2)
                    A.get(i).set(j, 0);
            }
        }

        System.out.println(A);

    }


    private void clearRow(ArrayList<ArrayList<Integer>> A, int row, int m, int n, int value) {

        for (int i = 0; i < n; i++) {
            if (A.get(row).get(i) == 1)
                A.get(row).set(i, value);
        }
    }

    private void clearCol(ArrayList<ArrayList<Integer>> A, int col, int m, int n, int value) {
        for (int i = 0; i < m; i++) {
            if (A.get(i).get(col) == 1)
                A.get(i).set(col, value);
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros instance = new SetMatrixZeros();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        instance.setZeroesV2(matrix);
    }
}
