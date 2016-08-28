package Math;

import java.util.ArrayList;

/**
 * Created by OlehKa on 12.06.2016.
 */
public class MathBug {

    public int isPrime(int A) {
        if (A == 0 || A == 1) return 0;
        int upperLimit = (int)(Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (i < A && A % i == 0) return 0;
        }
        return 1;
    }

    public ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int a = 0; a * a < A; a++) {
            for (int b = 0; b * b < A; b++) {
                if (a * a + b * b == A && a <= b) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    newEntry.add(a);
                    newEntry.add(b);
                    ans.add(newEntry);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MathBug instance = new MathBug();
        System.out.println(instance.squareSum(10));
        System.out.println(instance.squareSum(100));
        System.out.println(instance.squareSum(99));
        System.out.println(instance.squareSum(0));
        System.out.println(instance.squareSum(1));
        System.out.println(instance.squareSum(2));
        System.out.println(instance.squareSum(3));
    }
}
