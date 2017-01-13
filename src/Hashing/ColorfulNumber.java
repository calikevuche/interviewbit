package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by OlehKa on 18.12.2016.
 */
public class ColorfulNumber {

    public int colorful(int a) {
        List<Integer> num = new ArrayList<>();
        while (a != 0) {
            int digit = a % 10;
            num.add(0,digit);
            a = a / 10;
        }
        HashSet<Long> productSet = new HashSet<>();
        int size = 0;
        while (size < num.size()) {
            for (int i = 0; i < num.size(); i++) {
                List<Integer> subset = new ArrayList<>();
                if (i+size+1 > num.size()) continue;
                for (int j = i; j < i+size+1; j++) {
                    subset.add(num.get(j));
                }
                long product = 1;
                for (int digit: subset) {
                    product *= digit;
                }
                boolean result = productSet.add(product);
                if (!result) return 0;
            }
            size++;
        }
        return 1;
    }

    public static void main(String[] args) {
        ColorfulNumber colorfulNumber = new ColorfulNumber();
        int a1 = colorfulNumber.colorful(12345);
        int a2 = colorfulNumber.colorful(3245);
        System.out.println(a1);
        System.out.println(a2);
    }
}
