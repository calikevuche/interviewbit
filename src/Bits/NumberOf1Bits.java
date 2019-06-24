package Bits;

/**
 * Created by OlehKa on 14.08.2016.
 */
public class NumberOf1Bits {

    public int numSetBits0(long a) {
        int result = 0;
        while (a > 0) {
            int rem = (int) (a % 2);
            if (rem == 1) result++;
            a /= 2;
        }
        return result;
    }

    public int numSetBits1(long a) {
        int result = 0;
        while (a > 0) {
            a = a & (a - 1);
            result++;
        }
        return result;
    }

    public int numSetBits2(long a) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (int) (a & (1 << i));
            if (bit != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits instance = new NumberOf1Bits();
        System.out.println(instance.numSetBits2(45));
    }
}
