package Strings;

/**
 * Created by OlehKa on 01.08.2016.
 */
public class RomanToInteger {

    public int romanToInt(String a) {
        int result = 0;
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int startResult = result;
            if (i+1 < chars.length) {
                char next = chars[i+1];
                if (c == 'I') {
                    if (next == 'V') result += 4;
                    else if (next == 'X') result += 9;
                } else if (c == 'X') {
                    if (next == 'L') result += 40;
                    else if (next == 'C') result += 90;
                } else if (c == 'C') {
                    if (next == 'D') result += 400;
                    else if (next == 'M') result += 900;
                }
            }
            if (startResult != result) {
                i++;
                continue;
            }
            if (c == 'I') result += 1;
            else if (c == 'V') result += 5;
            else if (c == 'X') result += 10;
            else if (c == 'L') result += 50;
            else if (c == 'C') result += 100;
            else if (c == 'D') result += 500;
            else if (c == 'M') result += 1000;
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        System.out.println(instance.romanToInt("XIII"));
        System.out.println(instance.romanToInt("MCMIV"));
        System.out.println(instance.romanToInt("MCMLIV"));
        System.out.println(instance.romanToInt("MCMXC"));
        System.out.println(instance.romanToInt("MMXIV"));
        System.out.println(instance.romanToInt("MMMMMMXIV"));
    }
}
