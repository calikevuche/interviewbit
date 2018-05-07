package Strings;

/**
 * Created by OlehKa on 01.08.2016.
 */
public class RomanToInteger {

    public int romanToIntV1(String a) {
        int result = 0;
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int startResult = result;
            if (i + 1 < chars.length) {
                char next = chars[i + 1];
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

    public int romanToIntV2(String a) {
        int result = 0;
        char[] ar = a.toCharArray();
        for (int i = 0; i < ar.length; i++) {
            if (i < ar.length - 1 && getInt(ar[i]) < getInt(ar[i+1])) {
                result -= getInt(ar[i]);
            } else {
                result += getInt(ar[i]);
            }
        }
        return result;
    }

    private int getInt(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        System.out.println(instance.romanToIntV2("XIII"));
        System.out.println(instance.romanToIntV2("MCMIV"));
        System.out.println(instance.romanToIntV2("MCMLIV"));
        System.out.println(instance.romanToIntV2("MCMXC"));
        System.out.println(instance.romanToIntV2("MMXIV"));
        System.out.println(instance.romanToIntV2("MMMMMMXIV"));
    }
}
