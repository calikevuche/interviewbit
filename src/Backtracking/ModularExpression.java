package Backtracking;

/**
 * Created by OlehKa on 31.10.2016.
 */
public class ModularExpression {

    // ( a ^ b ) % c

    public int Mod(int a, int b, int c) {
        if (b == 0) return 1 % c;
        long res = 0;
        if (b % 2 == 0) {
            res = Mod(a, b/2 ,c);
            res = (res * res) % c;
        } else {
            res = a % c;
            res = (res * Mod(a, b-1, c)) % c;
        }
        return (int) ((res + c) % c);
    }

    public static void main(String[] args) {

    }
}
