package Strings;

/**
 * Created by OlehKa on 30.07.2016.
 */
public class ImplementStrStr {

    public int strStrV1(final String haystack, final String needle) {
        if (haystack.length() == 0 || needle.length() == 0) return -1;
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int firstIdx = -1;
        for (int i = 0; i < haystackChars.length; i++) {
            if (firstIdx == -1) {
                if (haystackChars[i] == needleChars[0]) {
                    firstIdx = i;
                }
            }
            if (firstIdx != -1) {
                if (haystackChars[i] != needleChars[i - firstIdx]) {
                    i = firstIdx;
                    firstIdx = -1;
                } else if (i - firstIdx == needleChars.length - 1) {
                    return firstIdx;
                }
            }
        }
        return -1;
    }

    public int strStrV2(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty() ||
                needle == null || needle.isEmpty()) {
            return -1;
        }
        char[] str = haystack.toCharArray();
        char[] sub = needle.toCharArray();
        int k = 0;
        for (int i = 0; i < str.length; i++) {
            if (str.length - i < sub.length - k) {
                return -1;
            } else if (str[i] == sub[k]) {
                if (k == sub.length - 1) {
                    return i - k;
                } else {
                    k++;
                }
            } else {
                i -= k;
                k = 0;
            }
        }
        return -1;
    }

    // KMP Algorithm

    public int strStrKMP(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return -1;
        }
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[] lps = getLongestPrefixAsSuffix(s2);
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a.length - i < b.length - k) {
                return -1;
            } else if (a[i] == b[k]) {
                if (k == b.length -1) {
                    return i - k;
                } else {
                    k++;
                }
            } else {
                if (k > 0) {
                    k = lps[k - 1];
                    i--;
                }
            }
        }
        return -1;
    }

    public int[] getLongestPrefixAsSuffix(String s) {
        char[] chars = s.toCharArray();
        int[] lps = new int[chars.length];
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                lps[i] = 0;
            } else if (chars[i] == chars[k]) {
                lps[i] = k + 1;
                k++;
            } else {
               if (k > 0) {
                   k = lps[k - 1];
                   i--;
               } else {
                   lps[i] = 0;
               }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        ImplementStrStr instance = new ImplementStrStr();
//        System.out.println(instance.strStrKMP(
//                "aaaaabbabbaaaababbbbaaabbbaababaababbaabaabaaabbabab",
//                "bbbaababaa"));
        instance.getLongestPrefixAsSuffix("AABCXAABACAA");
    }
}
