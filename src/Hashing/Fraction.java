package Hashing;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by OlehKa on 31.12.2016.
 */
public class Fraction {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        String sign = (numerator > 0 ^ denominator > 0) ? "-" : "";
        long numer = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        HashMap<Long,Integer> map = new HashMap<>(); // numerator, index
        long diff = -1, temp = 0;
        if (numer >= denom) {
            temp = numer / denom;
            diff = numer - temp * denom;
            numer = diff * 10;
            sb.append(diff == 0 ? temp : temp+".");
        } else {
            numer *= 10;
            sb.append("0.");
        }
        while (diff != 0) {
            if (map.containsKey(numer)) {
                int index = map.get(numer);
                String s = sb.substring(index);
                sb.replace(index, index+sb.length(), "("+s+")");
                break;
            } else {
                map.put(numer, sb.length());
            }
            if (numer > denom) {
                temp = numer / denom;
                sb.append(temp);
                diff = numer - temp * denom;
                numer = diff * 10;
            } else {
                numer *= 10;
                sb.append("0");
            }
        }
        return sign+sb.toString();
    }

    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        String s = fraction.fractionToDecimal(-857, -413);
        System.out.println(s);
    }
}
