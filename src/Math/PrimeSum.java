package Math;

import java.util.ArrayList;

import static Math.Factorization.*;

/**
 * Created by OlehKa on 12.06.2016.
 */
public class PrimeSum {

    public ArrayList<Integer> primesum1(int a) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 2; i < a; i++) {
            if (isPrime(i) == 1 && isPrime(a - i) == 1) {
                arrayList.add(i);
                arrayList.add(a - i);
                return arrayList;
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> primesum2(int a) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer[] sieve = getSieveArray(a);
        for (int i = 2; i < a; i++) {
            if (sieve[i] == 1 && sieve[a - i] == 1) {
                arrayList.add(i);
                arrayList.add(a - i);
                return arrayList;
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        PrimeSum instance = new PrimeSum();
        System.out.println(instance.primesum2(12));
        System.out.println(instance.primesum2(20));
        System.out.println(instance.primesum2(16777214));
    }
}
