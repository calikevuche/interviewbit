package Strings;

/**
 * Created by OlehKa on 30.07.2016.
 */
public class ImplementStrStr {

    public int strStr(final String haystack, final String needle) {
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

    public static void main(String[] args) {
        ImplementStrStr instance = new ImplementStrStr();
        System.out.println(instance.strStr("abba", "ba"));
        System.out.println(instance.strStr("abba", "baa"));
        System.out.println(instance.strStr("", "baa"));
        System.out.println(instance.strStr("", ""));
        System.out.println(instance.strStr("b", "b"));
    }
}
