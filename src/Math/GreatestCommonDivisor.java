package Math;

/**
 * Created by OlehKa on 16.06.2016.
 */
public class GreatestCommonDivisor {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        GreatestCommonDivisor instance = new GreatestCommonDivisor();
        System.out.println(instance.gcd(2, 9));
    }
}
