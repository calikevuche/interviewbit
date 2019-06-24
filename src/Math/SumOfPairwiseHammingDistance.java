package Math;

public class SumOfPairwiseHammingDistance {

    public int hammingDistance(final int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] != A[j]) {
                    sum += hammingDistance(A[i], A[j]);
                    sum %= 1000000007;
                }
            }
        }
        return (sum * 2) % 1000000007;
    }

    private int hammingDistance(int bigger, int smaller) {
        if (bigger < smaller) {
            return hammingDistance(smaller, bigger);
        }
        int sum = 0;
        while (smaller > 0) {
            if (smaller % 2 != bigger % 2) {
                sum++;
            }
            smaller /= 2;
            bigger /= 2;
        }
        while (bigger > 0) {
            if (bigger % 2 == 1) {
                sum++;
            }
            bigger /= 2;
        }
        return sum;
    }

    public int hammingDistance2(final int[] A) {
        long sum = 0;
        int intBits = 32;
        for (int i = 0; i < intBits; i++) {
            int onesCount = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] % 2 == 1) {
                    onesCount++;
                }
                A[j] /= 2;
            }
            sum += (long) onesCount * (A.length - onesCount);
            sum %= 1000000007;
        }
        return (int) ((sum * 2) % 1000000007);
    }

    public int hammingDistance3(final int[] A) {
        int sum = 0;
        int intBits = 32;
        for (int i = 0; i < intBits - 1; i++) {
            int onesCount = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & 1 << i) != 0) {
                    onesCount++;
                }
            }
            sum += (2L * onesCount * (A.length - onesCount)) % 1000000007;
            sum %= 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfPairwiseHammingDistance ins = new SumOfPairwiseHammingDistance();
        int testA = ins.hammingDistance3(new int[]{2,4,6});
        System.out.println(testA);
    }
}
