package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OlehKa on 28.05.2016.
 */
public class SpiralOrderMatrixTwo {

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = A.size(); // rows
        int n = A.get(0).size(); // columns
        int T = 0;
        int B = m - 1;
        int L = 0;
        int R = n - 1;
        int dir = 0; // 0 - right, 1 - down, 2 - left, 3 - up

        while (T <= B && L <= R) {
            if (dir == 0) {
                for (int i = L; i <= R; i++) {
                    result.add(A.get(T).get(i));
                }
                T++;
            } else if (dir == 1) {
                for (int i = T; i <= B; i++) {
                    result.add(A.get(i).get(R));
                }
                R--;
            } else if (dir == 2) {
                for (int i = R; i >= L; i--) {
                    result.add(A.get(B).get(i));
                }
                B--;
            } else if (dir == 3) {
                for (int i = B; i >= T; i--) {
                    result.add(A.get(i).get(L));
                }
                L++;
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //initialize result matrix with 0 values
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arrayList.add(0);
            }
            result.add(arrayList);
        }

        int T = 0;
        int B = n - 1;
        int L = 0;
        int R = n - 1;
        int dir = 0; // 0 - right, 1 - down, 2 - left, 3 - up
        int value = 1;

        while (T <= B && L <= R) {
            if (dir == 0) {
                for (int i = L; i <= R; i++) {
                    result.get(T).set(i, value++);
                }
                T++;
            } else if (dir == 1) {
                for (int i = T; i <= B; i++) {
                    result.get(i).set(R, value++);
                }
                R--;
            } else if (dir == 2) {
                for (int i = R; i >= L; i--) {
                    result.get(B).set(i, value++);
                }
                B--;
            } else if (dir == 3) {
                for (int i = B; i >= T; i--) {
                    result.get(i).set(L, value++);
                }
                L++;
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralOrderMatrixTwo instance = new SpiralOrderMatrixTwo();
        System.out.println(instance.generateMatrix(5));
    }
}
