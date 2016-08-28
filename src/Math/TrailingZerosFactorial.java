package Math;

/**
 * Created by OlehKa on 18.06.2016.
 */
public class TrailingZerosFactorial {

    public int trailingZeroes1(int a) {
        if (a < 5) return 0;
        int result = 0;
        int num = 1;
        while (a >= Math.pow(5, num)) {
            result += a / Math.pow(5, num);
            num++;
        }
        return result;
    }

    public int trailingZeroes(int a) {
        int result = 0;
        while (a / 5 > 0) {
            result += a / 5;
            a /= 5;
        }
        return result;
    }

    public static void main(String[] args) {
        TrailingZerosFactorial instance = new TrailingZerosFactorial();
        System.out.println(instance.trailingZeroes(9247));
    }
}
