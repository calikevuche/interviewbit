package Strings;

/**
 * Created by OlehKa on 30.07.2016.
 */
public class Atoi {

    public int atoi0(final String a) {
        char[] chars = a.toCharArray();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (index1 == -1 && (c != ' ' && c != '+' && c != '-' && (c < '0' || c > '9'))) {
                break;
            }
            if (index1 == -1 && (c >= '0' && c <= '9' || c == '+' || c == '-') && (i == 0 || chars[i-1] == ' ')) {
                index1 = i;
            }
            if (index1 != -1) {
                if (i == chars.length-1) {
                    index2 = i;
                } else if (i != index1 && (c == ' ' || c < '0' || c > '9')){
                    index2 = i-1;
                    break;
                } else if (c < '0' || c > '9') {
                    if (!(index1 == i && (c == '+' || c == '-'))) index1 = -1;
                }
            }
        }
        if (index1 == -1 && index2 == -1) return 0;
        String numSrt = a.substring(index1, index2+1);
        long result = 0;
        char[] numbers = numSrt.toCharArray();
        int koef = 1;
        int start = 0;
        if (numbers[0] == '+') {
            start = 1;
        } else if (numbers[0] == '-') {
            koef = -1;
            start = 1;
        }
        for (int i = start; i < numbers.length; i++) {
            result = result * 10 + Character.getNumericValue(numbers[i]);
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return koef == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        result = koef * result;
        return (int) result;
    }

    public int atoi(final String a) {
        char[] str = a.toCharArray();
        int sign = 1, base = 0, i = 0;
        while (str[i] == ' ') { i++; }
        if (str[i] == '-' || str[i] == '+') {
            sign = (str[i++] == '-') ? -1 : 1;
        }
        while (str[i] >= '0' && str[i] <= '9') {
            if (base >  Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str[i] - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base  = 10 * base + (str[i++] - '0');
        }
        return base * sign;
    }

    public static void main(String[] args) {
        Atoi instance = new Atoi();
        System.out.println(instance.atoi("9 2704"));
        System.out.println(instance.atoi("9a 2704"));
        System.out.println(instance.atoi(" dadad  2704   aasdasd"));
        System.out.println(instance.atoi("  +721+4 daafs"));
        System.out.println(instance.atoi("-6435D56183011M11   648G1 903778065  762 75316456373673B5 334 19885 90668 8 98K  X277 9846 "));
        System.out.println(instance.atoi(" V515V 5793K 627 23815945269 1 1249794L 631 8755 7"));
        System.out.println(instance.atoi("-54332872018247709407 4 54"));
    }
}
