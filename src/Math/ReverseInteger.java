package Math;

/**
 * Created by OlehKa on 25.06.2016.
 */
public class ReverseInteger {

    public int reverse(int a) {
        if (a == 0) {
            return 0;
        }
        long reverse = 0;
        if (a > 0) {
            while (a > 0) {
                int digit = a % 10;
                reverse = reverse * 10 + digit;
                a = a / 10;
            }
        } else {
            while (a < 0) {
                int digit = a % 10;
                reverse = reverse * 10 + digit;
                a = a / 10;
            }
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }

    public static void main(String[] args) {
        ReverseInteger instance = new ReverseInteger();
        System.out.println(instance.reverse(123));
        System.out.println(instance.reverse(123456));
        System.out.println(instance.reverse(2147483647));
        System.out.println(instance.reverse(-123));
        System.out.println(instance.reverse(-2147483647));
    }
}
