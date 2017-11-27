package Strings;

/**
 * Created by OlehKa on 28.07.2016.
 */
public class CountAndSay {

    public String countAndSay(int a) {
        if (a == 0) return "";
        String result = "1";
        for (int i = 0; i < a - 1; i++) {
            result = generateNext(result);
        }
        return result;
    }

    public String generateNext(String str) {
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

    public static void main(String[] args) {
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(2));
    }
}
