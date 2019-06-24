package Math;

/**
 * Created by OlehKa on 26.06.2016.
 */
public class GridUniquePaths {

    public int uniquePaths0(int a, int b) {
        if (a == 1 || b == 1) {
            return 1;
        }
        return uniquePaths0(a - 1, b) + uniquePaths0(a, b - 1);
    }

    // CORRECT
    public int uniquePaths1(int a, int b) {
        // m+n-2 C n-1 = (m+n-2)!/(n-1)!
        long ans = 1;
        for (int i = a; i < (b + a - 1); i++) {
            ans *= i;
            ans /= (i - a + 1);
        }
        return (int) ans;
    }

    // WRONG
    public int uniquePaths2(int a, int b) {
        // (m+n-2)!/(n-1)!(m-1)!
        long ans = 1;
        long x1 = 1, x2 = 1, x3 = 1;
        for (int i = 2; i < a + b - 1; i++) {
            x1 *= i;
        }
        for (int i = 2; i < a; i++) {
            x2 *= i;
        }
        for (int i = 2; i < b; i++) {
            x3 *= i;
        }
        ans = x1 / (x2 * x3);
        return (int) ans;
    }

    public static void main(String[] args) {
        GridUniquePaths instance = new GridUniquePaths();
        System.out.println(instance.uniquePaths1(2, 2));
        System.out.println(instance.uniquePaths1(3, 3));
        System.out.println(instance.uniquePaths1(7, 3));
        System.out.println(instance.uniquePaths1(100, 1));
    }
}
