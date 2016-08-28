package Math;

import java.util.ArrayList;
import java.util.Objects;

import static Math.Factorization.*;
import static Math.GreatestCommonDivisor.*;

/**
 * Created by OlehKa on 23.06.2016.
 */
public class PowerOfTwoIntegers {

//    A^P where P > 1 and A > 0

    public boolean isPower0(int a) {
        if (isPrime(a) == 1) {
            return false;
        }
        ArrayList<Integer> factors = allPrimeFactors(a);
        if (factors.size() >= 2 && Objects.equals(factors.get(0), factors.get(factors.size() - 1))) {
            return true;
        }
        System.out.println("a="+a+" "+factors);

        int minNum = 0;
        int num = 0;
        int previous = factors.get(0);
        for (int i = 0; i < factors.size(); i++) {
            if (previous != factors.get(i)) {
                if (minNum == 0 || num < minNum) {
                    minNum = num;
                }
                num = 0;
            }
            previous = factors.get(i);
            num++;
        }
        if (minNum == 1) {
            return false;
        }
        num = 0;
        previous = factors.get(0);
        for (int i = 0; i < factors.size(); i++) {
            if (previous != factors.get(i)) {
                if (gcd(minNum, num) == 1) {
                    return false;
                }
                num = 0;
            }
            previous = factors.get(i);
            num++;
        }
        if (gcd(minNum, num) == 1) {
            return false;
        }

        return true;
    }

    public boolean isPower(int a) {
        if (a <= 1) return true;
        for (int base = 2; base < a && base < Integer.MAX_VALUE / base; base++) {
            int temp = base;
            while (temp <= a && temp < Integer.MAX_VALUE / base) {
                temp *= base;
                if (temp == a) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PowerOfTwoIntegers instance = new PowerOfTwoIntegers();
        System.out.println(instance.isPower(100));
        System.out.println(instance.isPower(105));
        System.out.println(instance.isPower(536870912));
        System.out.println(instance.isPower(729));
        System.out.println(instance.isPower(5929));
        System.out.println(instance.isPower(711));
        System.out.println(instance.isPower(2));
        System.out.println(instance.isPower(1024000000));
    }
}
