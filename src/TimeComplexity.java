/**
 * Created by OlehKa on 23.05.2016.
 */
public class TimeComplexity {

    void nestedCmpl3(int N) {
        int c = 0;
        for (int i = N; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                c += 1;
                System.out.println(c);
            }
        }
    }

    int gcd(int n, int m) {
        if (n % m == 0) return m;
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        while (m > 0) {
            n = n % m;
            int temp = n;
            n = m;
            m = temp;
            System.out.println(n + " " + m);
        }
        return n;
    }

    public static void main(String[] args) {
        TimeComplexity instance = new TimeComplexity();
//        instance.nestedCmpl3(10);
        instance.gcd(1124232133, 112421413);
    }
}
