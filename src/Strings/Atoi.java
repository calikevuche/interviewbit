package Strings;

/**
 * Created by OlehKa on 30.07.2016.
 */
public class Atoi {

    public int atoiV1(final String a) {
        char[] chars = a.toCharArray();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (index1 == -1 && (c != ' ' && c != '+' && c != '-' && (c < '0' || c > '9'))) {
                break;
            }
            if (index1 == -1 && (c >= '0' && c <= '9' || c == '+' || c == '-') && (i == 0 || chars[i - 1] == ' ')) {
                index1 = i;
            }
            if (index1 != -1) {
                if (i == chars.length - 1) {
                    index2 = i;
                } else if (i != index1 && (c == ' ' || c < '0' || c > '9')) {
                    index2 = i - 1;
                    break;
                } else if (c < '0' || c > '9') {
                    if (!(index1 == i && (c == '+' || c == '-'))) index1 = -1;
                }
            }
        }
        if (index1 == -1 && index2 == -1) return 0;
        String numSrt = a.substring(index1, index2 + 1);
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

    public int atoiV2(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        boolean negative = false;
        while (start < chars.length && chars[start] == ' ') {
            start++;
        }
        if (start < chars.length) {
            if (chars[start] == '+') {
                start++;
                negative = false;
            } else if (chars[start] == '-') {
                start++;
                negative = true;
            }
        }
        while (start < chars.length && chars[start] == '0') {
            start++;
        }
        end = start;
        while (end < chars.length && chars[end] >= '0' && chars[end] <= '9') {
            end++;
        }
        if (start == end) {
            return 0;
        }
        String sub = s.substring(start, end);
        chars = sub.toCharArray();
        int num = 0, shift = 0, result = 0;
        long val = 0L;
        for (int i = chars.length - 1; i >= 0; i--) {
            num = chars[i] - '0';
            shift = chars.length - 1 - i;
            val = (long)num * (int)Math.pow(10, shift);
            if (negative) {
                val = -val;
                if (val < Integer.MIN_VALUE || Integer.MIN_VALUE - result > (int)val) {
                    return Integer.MIN_VALUE;
                } else {
                    result += (int)val;
                }
            } else {
                if (val > Integer.MAX_VALUE || Integer.MAX_VALUE - result < (int)val) {
                    return Integer.MAX_VALUE;
                } else {
                    result += (int)val;
                }
            }
        }
        return result;
    }

    public int atoiV3(final String a) {
        char[] str = a.toCharArray();
        int sign = 1, base = 0, i = 0;
        while (i < str.length && str[i] == ' ') {
            i++;
        }
        if (i < str.length && (str[i] == '-' || str[i] == '+')) {
            sign = (str[i++] == '-') ? -1 : 1;
        }
        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str[i] - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base = 10 * base + (str[i++] - '0');
        }
        return base * sign;
    }

    public static void main(String[] args) {
        Atoi instance = new Atoi();
        System.out.println(instance.atoiV2("9 2704"));
        System.out.println(instance.atoiV2("7 U 0 T7165 0128862 089 39 5"));
        System.out.println(instance.atoiV2("+7"));
        System.out.println(instance.atoiV2("-88297 248252140B12 37239U4622733246I218 9 1303 44 A83793H3G2 1674443R591 4368 7 97"));
    }
}
