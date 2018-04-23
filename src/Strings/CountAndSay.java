package Strings;

/**
 * Created by OlehKa on 28.07.2016.
 */
public class CountAndSay {

    public String countAndSayV1(int a) {
        if (a == 0) return "";
        String result = "1";
        for (int i = 0; i < a - 1; i++) {
            result = generateNext(result);
        }
        return result;
    }

    private String generateNext(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        char current, prev = chars[0];
        int counter = 1;
        if (chars.length == 1) {
            return "1" + str;
        }
        for (int i = 1; i < chars.length; i++) {
            current = chars[i];
            if (current != prev) {
                builder.append(counter);
                builder.append(prev);
                counter = 1;
            } else {
                counter++;
            }
            prev = current;
            if (i == chars.length - 1) {
                builder.append(counter);
                builder.append(prev);
            }
        }
        return builder.toString();
    }

    public String countAndSayV2(int n) {
        if (n <= 0) {
            return "";
        }
        String string = "1";
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            char[] chars = string.toCharArray();
            char ch = 0;
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (j == 0) {
                    ch = chars[0];
                    count = 1;
                } else if (chars[j] == ch) {
                    count++;
                } else {
                    sb.append(count).append(ch);
                    ch = chars[j];
                    count = 1;
                }
            }
            sb.append(count).append(ch);
            string = sb.toString();
            sb.delete(0, sb.length());
        }
        return string;
    }

    public static void main(String[] args) {
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSayV2(1));
        System.out.println(instance.countAndSayV2(2));
        System.out.println(instance.countAndSayV2(3));
        System.out.println(instance.countAndSayV2(4));
        System.out.println(instance.countAndSayV2(5));
        System.out.println(instance.countAndSayV2(6));
        System.out.println(instance.countAndSayV2(7));
        System.out.println(instance.countAndSayV2(8));
    }
}
