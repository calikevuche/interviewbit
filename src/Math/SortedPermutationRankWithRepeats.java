package Math;

public class SortedPermutationRankWithRepeats {

    // mod 1000003
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

            long dfac = 1;
            int[] table = repeatedTable(A, i);
            long temp = smallers * factorial(places, 1000003);

            for (int j = 0; j < table.length; j++) {
                dfac = factorial(table[j], 1000003);
                temp *= inverseNumber(dfac, 1000003);
                temp %= 1000003;
            }

            rank += temp;
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

    private int[] repeatedTable(String s, int start) {
        int[] table = new int[52]; // 26 UPPER + 26 lower letters
        for (int i = 0; i < table.length; i++) {
            table[i] = 0;
        }
        for (int i = start; i < s.length(); i++) {
            int val = s.charAt(i);
            if (val >= 'A' && val <= 'Z') {
                table[val - 'A']++;
            }
            if (val >= 'a' && val <= 'z') {
                table[val - 'a' + 26]++;
            }
        }
        return table;
    }

    private long inverseNumber(long num, int mod) {
        long ans = 1, base = num;
        int power = mod - 2;
        while (power > 0) {
            if (power == 1) {
                return (ans * base) % mod;
            }
            if (power % 2 == 0) {
                base = (base * base) % mod;
                power /= 2;
            } else {
                ans = (ans * base) % mod;
                power--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SortedPermutationRankWithRepeats ins = new SortedPermutationRankWithRepeats();
        int testA = ins.findRank("asasdsdsadasdadsadasdsa");
        System.out.println(testA);
    }
}
