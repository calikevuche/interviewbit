package BinarySearch;

/**
 * Created by OlehKa on 10.07.2016.
 */
public class PowerFunction {

    public int pow(int x, int n, int d) {
        if (x == 0 || d == 1) return 0;
        if (n == 0) return 1;
        long result = 1;
        long base = x;
        while (n > 0) {
            if (n % 2 == 0) {
                base = (base * base) % d;
                n /= 2;
            } else {
                result = (result * base) % d;
                n--;
            }
        }
        if (result < 0) result = result + d;
        return (int) (result);
    }

    public static void main(String[] args) {
        PowerFunction instance = new PowerFunction();
        System.out.println(instance.pow(11, 3, 25));
        System.out.println(instance.pow(11, 4, 25));
    }
}
