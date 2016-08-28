package Strings;

/**
 * Created by OlehKa on 29.07.2016.
 */
public class ReverseString {

    public String reverseWords(String a) {
        if (a.equals("")) return "";
        char[] chars = a.toCharArray();
        StringBuilder result = new StringBuilder();
        int left = -1, right = -1;
        int i = 0;
        String word;
        while (i < chars.length) {
            if (chars[i] != ' ') {
                if (left == -1) left = i;
            } else if (left != -1) {
                right = i;
                word = a.substring(left, right)+" ";
                result.insert(0, word);
                left = -1;
                right = -1;
            }
            i++;
        }
        if (left != -1) {
            word = a.substring(left)+" ";
            result.insert(0, word);
        }
        int lastIndex = result.length()-1;
        if (lastIndex >= 0 && result.charAt(lastIndex) == ' ') {
            result.deleteCharAt(lastIndex);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReverseString instance = new ReverseString();
        System.out.println(instance.reverseWords("aaa sss"));
        System.out.println(instance.reverseWords("  aaa   sss   "));
        System.out.println(instance.reverseWords(""));
        System.out.println(instance.reverseWords(" "));
        System.out.println(instance.reverseWords("   "));
        System.out.println(instance.reverseWords("a"));
        System.out.println(instance.reverseWords(" a "));
    }
}
