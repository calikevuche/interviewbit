package Bits;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 14.08.2016.
 */
public class SingleNumber {

    // DO NOT MODIFY THE LIST
    public int singleNumber(final List<Integer> a) {
        int result = 0;
        for (int num: a) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber instance = new SingleNumber();
        System.out.println(instance.singleNumber(Arrays.asList(1,2,2,3,1)));
    }
}
