package Math;

public class SortedPermutationRank {

    public int findRank(String A) {
        long rank = 0;
        for (int i = 0; i < A.length(); i++) {
            char cur = A.charAt(i);
            char next;
            int smallers = 0;
            int places = A.length() - i - 1;
            for (int j = i + 1; j < A.length(); j++) {
                next = A.charAt(j);
                if (next < cur) {
                    smallers++;
                }
            }
            rank += (long) smallers * factorial(places, 1000003);
            rank %= 1000003;
        }
        return (int) rank + 1;
    }

    private long factorial(int num, int mod) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
            result %= mod;
        }
        return result;
    }

    public static void main(String[] args) {
        SortedPermutationRank ins = new SortedPermutationRank();
        int testA = ins.findRank("string");
        System.out.println(testA);
    }
}
