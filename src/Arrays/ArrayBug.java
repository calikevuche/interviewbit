package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 28.05.2016.
 */
public class ArrayBug {

    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            int index = (i + B) % A.size();
            ret.add(A.get(index));
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayBug instance = new ArrayBug();
        ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(instance.rotateArray(inputArray, 1));
    }
}
