package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 29.05.2016.
 */
public class WaveArray {

    public ArrayList<Integer> wave(ArrayList<Integer> array) {
        ArrayList<Integer> newArray = new ArrayList<>(array);
        Collections.sort(newArray);
        for (int i = 0; i < newArray.size()-1; i += 2) {
            int temp = newArray.get(i);
            newArray.set(i, newArray.get(i+1));
            newArray.set(i+1, temp);
        }
        return newArray;
    }

    public static void main(String[] args) {
        WaveArray ins = new WaveArray();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(6,5,4,3));
        ins.wave(input);
    }
}
