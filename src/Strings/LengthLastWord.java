package Strings;

/**
 * Created by OlehKa on 29.07.2016.
 */
public class LengthLastWord {

    public int lengthOfLastWordV1(final String a) {
        if (a.length() == 0) return 0;
        char[] chars = a.toCharArray();
        int right = chars.length - 1;
        int left = right;
        char c = chars[left];
        boolean isLetter = c != ' ';
        while ((!isLetter || c != ' ') && --left >= 0) {
            c = chars[left];
            if (!isLetter && c != ' ') {
                isLetter = true;
                right = left;
            }
        }
        if (!isLetter) return 0;
        else return right - left;
    }

    public int lengthOfLastWordV2(final String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ar = s.toCharArray();
        int i = 0, j = 0, len = ar.length;
        while (i < len && ar[len - 1 - i] == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        j = i;
        while (j < len && ar[len - 1 - j] != ' ') {
            j++;
        }
        return j - i;
    }

    public static void main(String[] args) {
        LengthLastWord instance = new LengthLastWord();
        System.out.println(instance.lengthOfLastWordV1("a"));
        System.out.println(instance.lengthOfLastWordV1("aaa"));
        System.out.println(instance.lengthOfLastWordV1("Hello World "));
        System.out.println(instance.lengthOfLastWordV1(""));
        System.out.println(instance.lengthOfLastWordV1("    "));
    }
}
