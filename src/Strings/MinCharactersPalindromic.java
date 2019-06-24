package Strings;

public class MinCharactersPalindromic {

    public int solve(String A) {
        if (A.length() == 0 || isPalindrom(A, A.length())) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A.length(); i++) {
            int j = i, k = i;
            while (j >= 0 && k < A.length() && A.charAt(j) == A.charAt(k)) {
                if (j == 0) {
                    int diff = A.length() - k - 1;
                    if (diff < result) {
                        result = diff;
                    }
                }
                j--;
                k++;
            }
            j = i; k = i + 1;
            while (j >= 0 && k < A.length() && A.charAt(j) == A.charAt(k)) {
                if (j == 0) {
                    int diff = A.length() - k - 1;
                    if (diff < result) {
                        result = diff;
                    }
                }
                j--;
                k++;
            }
        }
        return result;
    }

    public int solve2(String A) {
        if (A.length() == 0 || isPalindrom(A, A.length())) {
            return 0;
        }
        int end = A.length();
        while (end > 1 && isPalindrom(A, end)) {
            end--;
        }
        return A.length() - end;
    }

    private boolean isPalindrom(String s, int length) {
        int i = 0, j = length - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    // KMP algorithm
    public int solve3(String A) {
        StringBuilder sb = new StringBuilder(A);
        String concat = sb + "$" + sb.reverse();
        int[] lps = lpsArray(concat);
        return A.length() - lps[lps.length - 1];
    }

    private int[] lpsArray(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        MinCharactersPalindromic ins = new MinCharactersPalindromic();
        int testA = ins.solve("AACECAAAAAACECAAAAACECAAAA");
        System.out.println(testA);
    }
}
