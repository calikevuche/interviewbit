package Strings;

import java.util.ArrayList;

/**
 * Created by OlehKa on 07.08.2016.
 */
public class ZigzagString {

    public String convertV1(String a, int b) {
        if (b == 1) return a;
        StringBuilder result = new StringBuilder();
        char[] chars = a.toCharArray();
        int T = (b - 1) * 2, T1, T2;
        for (int i = 0; i < b; i++) {
            if (i == 0 || i == b - 1) {
                for (int j = i; j < a.length(); j += T) {
                    result.append(chars[j]);
                }
            } else {
                T1 = (b - 1 - i) * 2;
                T2 = i * 2;
                boolean second = false;
                for (int j = i; j < a.length(); ) {
                    result.append(chars[j]);
                    j += second ? T2 : T1;
                    second = !second;
                }
            }
        }
        return result.toString();
    }

    public String convertV2(String a, int b) {
        if (b == 1) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int down = 0, up = 0;
        boolean isDown = false;
        for (int i = 0; i < b; i++) {
            isDown = true;
            down = 2 * (b - 1 - i);
            up = 2 * i;
            for (int j = i; j < a.length(); ) {
                if ((isDown && down != 0) ||
                        (!isDown && up != 0)) {
                    stringBuilder.append(a.charAt(j));
                    j += isDown ? down : up;
                }
                isDown = !isDown;
            }
        }
        return stringBuilder.toString();
    }

    public String convertV3(String a, int b) {
        if (b == 1) {
            return a;
        }
        int level = 0, step = 0;
        ArrayList<StringBuilder> arrayList = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b; i++) {
            arrayList.add(new StringBuilder());
        }
        for (int i = 0; i < a.length(); i++) {
            arrayList.get(level).append(a.charAt(i));
            if (level == 0) {
                step = 1;
            } else if (level == b - 1) {
                step = -1;
            }
            level += step;
        }
        for (int i = 0; i < b; i++) {
            result.append(arrayList.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagString instance = new ZigzagString();
        System.out.println(instance.convertV1("PAYPALISHIRING", 3));
        System.out.println(instance.convertV2("PAYPALISHIRING", 3));
        System.out.println(instance.convertV3("PAYPALISHIRING", 3));
    }
}
