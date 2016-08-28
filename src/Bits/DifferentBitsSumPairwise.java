package Bits;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 17.08.2016.
 */
public class DifferentBitsSumPairwise {

    public static final long MOD = 1_000_000_007L;

    public int cntBits(ArrayList<Integer> A) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i);
            for (int j = i+1; j < A.size(); j++) {
                int b = A.get(j);
                sum += getDiffBits(a,b) % MOD;
                sum %= MOD;
            }
        }
        return (int) ((2*sum) % MOD);
    }

    public int getDiffBits(int a, int b) {
        return numSetBits(a ^ b);
    }

    public int numSetBits(long a) {
        int result = 0;
        while (a > 0) {
            a = a & (a-1);
            result++;
        }
        return result;
    }


    // version 2.0

    public int cntBits2(ArrayList<Integer> A) {
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            long countZeros = 0;
            for (int j = 0; j < A.size(); j++) {
                int bit = A.get(j) & (1 << i);
                if (bit == 0) countZeros++;
            }
            sum += (countZeros * (A.size()-countZeros) * 2L) % MOD;
            if (sum >= MOD) sum -= MOD; // VERY IMPORTANT !!! VERY IMPORTANT
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        DifferentBitsSumPairwise instance = new DifferentBitsSumPairwise();
        System.out.println(instance.cntBits2(new ArrayList<>(Arrays.asList(1, 3, 5))));
    }
}
