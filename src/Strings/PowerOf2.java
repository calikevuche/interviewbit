package Strings;

/**
 * Created by OlehKa on 04.08.2016.
 */
public class PowerOf2 {

    int powerOfTwoV0(String a) {
        int n = Integer.valueOf(a);
        while (n >= 1 && n % 2 == 0) {
            n = n / 2;
        }
        if (n == 1) return 1;
        else return 0;
    }

    //SOLUTION

    int powerOfTwoV1(String a) {
        if (a.length() == 0 || (a.equals("1"))) return 0;
        String result = a;
        while (!(result.length() == 1 && result.charAt(0) <= '1') && isEven(result)) {
            result = divBy2(result);
        }
        if (result.length() == 1 && result.charAt(0) == '1') return 1;
        else return 0;
    }

    private boolean isEven(String str) {
        char c = str.charAt(str.length() - 1);
        int i = c - '0';
        return i % 2 == 0;
    }

    private String divBy2(String str) {
        String result = "";
        char[] chars = str.toCharArray();
        int carry = 0;
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            int digit = carry * 10 + (chars[i] - '0');
            carry = digit % 2;
            value = digit / 2;
            result += value;
        }
        result = trimFirstZeros(result);
        return result.equals("") ? "0" : result;
    }

    private String trimFirstZeros(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == '0') {
            i++;
        }
        return str.substring(i);
    }

    int powerOfTwoV2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = trimFirstZerosV2(s);
        if (isOne(s)) {
            return 0;
        }
        while (!isOne(s)) {
            s = divideByTwo(s);
            if (!isOne(s) && isOdd(s)) {
                return 0;
            }
        }
        return 1;
    }

    private String trimFirstZerosV2(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }

    private boolean isOne(String s) {
        return s != null && s.length() == 1 && s.charAt(0) == '1';
    }

    private boolean isOdd(String s) {
        return s != null && s.length() > 0 &&
                (s.charAt(s.length() - 1) - '0') % 2 == 1;
    }

    private StringBuilder stringBuilder = new StringBuilder();

    private String divideByTwo(String s) {
        stringBuilder.delete(0, stringBuilder.length());
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp += s.charAt(i) - '0';
            if (temp < 2) {
                stringBuilder.append(0);
            } else {
                stringBuilder.append(temp / 2);
                temp %= 2;
            }
            temp *= 10;
        }
        return trimFirstZerosV2(stringBuilder.toString());
    }

    public static void main(String[] args) {
        PowerOf2 instance = new PowerOf2();
        System.out.println(instance.powerOfTwoV2("65532"));
        System.out.println(instance.powerOfTwoV2("65536"));
        System.out.println(instance.powerOfTwoV2("147573952589676412928"));
        System.out.println(instance.powerOfTwoV2("101"));
        System.out.println(instance.powerOfTwoV2("0"));
    }
}
