package Bits;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 14.08.2016.
 */
public class SingleNumberII {

    // DO NOT MODIFY THE LIST
    public int singleNumber(final List<Integer> a) {
        int mask1 = 0;
        int mask2 = 0;
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            int j = 0;
            while (j < 32) {
                int bit = num & (1 << j);
                if (bit != 0) {
                    int bit1 = bit & mask1;
                    if (bit1 != 0) {
                        int bit2 = bit & mask2;
                        if (bit2 != 0) {
                            mask1 &= ~bit;
                            mask2 &= ~bit;
                        } else {
                            mask2 |= bit;
                        }
                    } else {
                        mask1 |= bit;
                    }
                }
                j++;
            }
        }
        return mask1;
    }

    public static void main(String[] args) {
        SingleNumberII instance = new SingleNumberII();
        System.out.println(instance.singleNumber(Arrays.asList(1, 2, 5, 3, 3, 2, 2, 3, 1, 1)));
    }
}
