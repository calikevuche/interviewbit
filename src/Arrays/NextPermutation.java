package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

    public void nextPermutation(ArrayList<Integer> A) {
        int desricingStartIndex = A.size() - 1;
        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i - 1) >= A.get(i)) {
                desricingStartIndex--;
            } else {
                break;
            }
        }
        if (desricingStartIndex == 0) {
            Collections.reverse(A);
        } else {
            int leftIndex = desricingStartIndex - 1;
            int rightIndex = A.size() - 1;
            while (rightIndex >= desricingStartIndex && A.get(rightIndex) <= A.get(leftIndex)) {
                rightIndex--;
            }
            int temp = A.get(leftIndex);
            A.set(leftIndex, A.get(rightIndex));
            A.set(rightIndex, temp);
            Collections.reverse(A.subList(desricingStartIndex, A.size()));
        }
    }

    public static void main(String[] args) {
        NextPermutation ins = new NextPermutation();
        ArrayList<Integer> testList1 = new ArrayList<>(Arrays.asList(5, 1, 1, 3, 3, 2, 1));
        ArrayList<Integer> testList2 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5));
        ArrayList<Integer> testList3 = new ArrayList<>(Arrays.asList(5, 3, 2, 2, 1, 0, -2, -1));

        ins.nextPermutation(testList3);
        System.out.println(testList3);
    }
}
