package Strings;

/**
 * Created by OlehKa on 04.08.2016.
 */
public class PowerOf2 {

    int power0(String a) {
        int n = Integer.valueOf(a);
        while (n >= 1 && n % 2 == 0) {
            n = n / 2;
        }
        if (n == 1) return 1;
        else return 0;
    }

    //SOLUTION

    int power(String a) {
        if (a.length() == 0 || (a.equals("1"))) return 0;
        String result = a;
        while (!(result.length() == 1 && result.charAt(0) <= '1') && isEven(result)) {
            result = divBy2(result);
        }
        if (result.length() == 1 && result.charAt(0) == '1') return 1;
        else return 0;
    }

    boolean isEven(String str) {
        char c = str.charAt(str.length()-1);
        int i = c - '0';
        return i % 2 == 0;
    }

    String divBy2(String str) {
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

    String trimFirstZeros(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == '0') {
            i++;
        }
        return str.substring(i);
    }

    public static void main(String[] args) {
        PowerOf2 instance = new PowerOf2();
        System.out.println(instance.power("65532"));
        System.out.println(instance.power("65536"));
        System.out.println(instance.power("147573952589676412928"));
        System.out.println(instance.power("101"));
        System.out.println(instance.power("0"));
    }
}
