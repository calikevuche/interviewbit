package Math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 12.06.2016.
 */
public class Factorization {

    public static ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> factors = new ArrayList<>();

        int index = 0;
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                factors.add(index, i);
                if (i != a / i) {
                    factors.add(index + 1, a / i);
                }
                index++;
            }
        }

        return factors;
    }

    public static ArrayList<Integer> allPrimeFactors(int a) {
        ArrayList<Integer> factors = new ArrayList<>();
        if (isPrime(a) == 0) {
            for (int i = 2; i <= a; i++) {
                if (isPrime(i) == 1 && a % i == 0) {
                    factors.add(i);
                    a = a / i;
                    i = 1;
                }
            }
        }
        return factors;
    }

    // 1 - is prime, 0 - not prime
    public static int isPrime(int a) {
        if (a < 2) return 0;
        else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public static Integer[] getSieveArray(int a) {
        Integer[] sieve = new Integer[a + 1];
        Arrays.fill(sieve, 1);
        sieve[0] = 0;
        sieve[1] = 1;

        for (int i = 2; i < Math.sqrt(a); i++) {
            for (int j = 2; j * i <= a; j++) {
                sieve[j * i] = 0;
            }
        }

        return sieve;
    }

    // 1 - is prime, 0 - not prime
    public static ArrayList<Integer> sieve(int a) {
        Integer[] sieve = getSieveArray(a);

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i] == 1) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        Factorization instance = new Factorization();
        System.out.println(instance.allFactors(36));
        System.out.println(instance.allPrimeFactors(36));
        System.out.println(instance.allPrimeFactors(27));
        System.out.println(instance.allPrimeFactors(360));
        System.out.println(instance.isPrime(3));
        System.out.println(instance.isPrime(17));
        System.out.println(instance.sieve(12));
    }
}
