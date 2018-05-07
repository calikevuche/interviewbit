package Strings;

/**
 * Created by OlehKa on 29.07.2016.
 */
public class ReverseString {

    public String reverseWordsV1(String a) {
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
                word = a.substring(left, right) + " ";
                result.insert(0, word);
                left = -1;
                right = -1;
            }
            i++;
        }
        if (left != -1) {
            word = a.substring(left) + " ";
            result.insert(0, word);
        }
        int lastIndex = result.length() - 1;
        if (lastIndex >= 0 && result.charAt(lastIndex) == ' ') {
            result.deleteCharAt(lastIndex);
        }
        return result.toString();
    }

    public String reverseWordsV2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] ar = s.toCharArray();
        int i = 0, j = 0, len = ar.length;
        while (i < len && ar[len - 1 - i] == ' ') {
            i++;
        }
        if (i == len) {
            return "";
        }
        j = i;
        StringBuilder res = new StringBuilder();
        while (i < len && j < len) {
            if (ar[len - 1 - j] != ' ') {
                j++;
            } else if (j > i) {
                res.append(s, len - j, len - i).append(' ');
                i = j;
            } else {
                i++;
                j++;
            }
        }
        if (j > i) {
            res.append(s, 0, len - i);
        }
        if (res.length() > 0 && res.charAt(res.length() - 1) == ' ') {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ReverseString instance = new ReverseString();
        System.out.println(instance.reverseWordsV2("aaa sss"));
        System.out.println(instance.reverseWordsV2("  aaa   sss   "));
        System.out.println(instance.reverseWordsV2(""));
        System.out.println(instance.reverseWordsV2(" "));
        System.out.println(instance.reverseWordsV2("   "));
        System.out.println(instance.reverseWordsV2("a"));
        System.out.println(instance.reverseWordsV2(" a "));

        String test = "abcd";
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(test, 0, 4));
        System.out.println(test.substring(0, 4));
    }
}
