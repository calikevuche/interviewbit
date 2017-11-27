package Bits;

/**
 * Created by OlehKa on 14.08.2016.
 */
public class ReverseBits {

    public long reverse(long a) {
        long result = 0;
        int n = 32;
        while (n > 0) {
            int rem = (int) (a % 2);
            result = result * 2 + rem;
            a >>= 1; // equals to a /= 2;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits instance = new ReverseBits();
        System.out.println(instance.reverse(3));
    }
}
