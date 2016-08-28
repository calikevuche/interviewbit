package Bits;

/**
 * Created by OlehKa on 15.08.2016.
 */
public class DivideIntegers {

    public int divide(int dividend, int divisor) {
        long N = dividend; // Numerator
        long D = divisor; // Denominator
        boolean isNegative = (N > 0) ^ (D > 0);
        if (N < 0) N = -N;
        if (D < 0) D = -D;
        long Q = 0; // quotient
        long R = 0; // reminder
        for (int i = 31; i >= 0; i--) {
            R <<= 1;
            long bit = (N >> i) & 1; // N[i]
            R |= bit; // R[0]=N[i]
            if (R >= D) {
                R -= D;
                Q |= (1L << i); // Q[i]=1
            }
        }
        if (isNegative) Q = -Q;
        return Q > Integer.MAX_VALUE || Q < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) Q;
    }

    public int divide1(int dividend, int divisor) {
        long N = dividend;
        long D = divisor;
        boolean isNegative = (N > 0) ^ (D > 0);
        if (N < 0) N = -N;
        if (D < 0) D = -D;
        long Q = 0;
        long T = 0; // tentative value
        for (int i = 31; i >= 0; i--) {
            if (T + (D << i) <= N) {
                T += (D << i);
                Q |= 1L << i;
            }
        }
        if (isNegative) Q = -Q;
        return Q > Integer.MAX_VALUE || Q < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) Q;
    }

    public static void main(String[] args) {
        DivideIntegers instance = new DivideIntegers();
        System.out.println(instance.divide(5,2));
        System.out.println(instance.divide(38,5));
        System.out.println(instance.divide(-2147483647,1));
        System.out.println(instance.divide(13,-1));
        System.out.println(instance.divide(-2147483648,-1));
        System.out.println(instance.divide(-1,1));
        System.out.println(instance.divide(1,-1));
    }
}
