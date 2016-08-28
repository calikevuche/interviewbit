package Strings;

/**
 * Created by OlehKa on 29.07.2016.
 */
public class LengthLastWord {

    public int lengthOfLastWord(final String a) {
        if (a.length() == 0) return 0;
        char[] chars = a.toCharArray();
        int right = chars.length-1;
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
        else return right-left;
    }

    public static void main(String[] args) {
        LengthLastWord instance = new LengthLastWord();
        System.out.println(instance.lengthOfLastWord("d"));
        System.out.println(instance.lengthOfLastWord("aaa"));
        System.out.println(instance.lengthOfLastWord("Hello World"));
        System.out.println(instance.lengthOfLastWord("Hello World "));
        System.out.println(instance.lengthOfLastWord("Hello World abcd!234"));
        System.out.println(instance.lengthOfLastWord(""));
        System.out.println(instance.lengthOfLastWord("    "));
    }
}
