package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 28.05.2016.
 */
public class SpiralOrderMatrixOne {

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m  = A.size(); // rows
        int n = A.get(0).size(); // columns
        int T = 0; int B = m - 1; int L = 0; int R = n - 1;
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

    public static void main(String[] args) {
        SpiralOrderMatrixOne instance = new SpiralOrderMatrixOne();

        List <ArrayList<Integer>> inputMatrix = new ArrayList<>();
        inputMatrix.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        inputMatrix.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        inputMatrix.add(new ArrayList<>(Arrays.asList(9,10,11,12)));

        System.out.println(instance.spiralOrder(inputMatrix));
    }
}
