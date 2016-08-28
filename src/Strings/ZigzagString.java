package Strings;

/**
 * Created by OlehKa on 07.08.2016.
 */
public class ZigzagString {

    public String convert(String a, int b) {
        if (b == 1) return a;
        String result = "";
        char[] chars = a.toCharArray();
        int T = (b-1)*2, T1, T2;
        for (int i = 0; i < b; i++) {
            if (i == 0 || i == b-1) {
                for (int j = i; j < a.length(); j+=T) {
                    result += chars[j];
                }
            } else {
                T1 = (b-1-i)*2;
                T2 = (i)*2;
                boolean second = false;
                for (int j = i; j < a.length(); ) {
                    result += chars[j];
                    j += second ? T2 : T1;
                    second = !second;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ZigzagString instance = new ZigzagString();
        instance.convert("PAYPALISHIRING", 3);
        instance.convert("ABCDEFGHIJKLMNO", 4);
        instance.convert("B", 1);
    }
}
