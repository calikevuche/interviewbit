package Strings;

/**
 * Created by OlehKa on 30.07.2016.
 */
public class CompareVersionNumbers {

    public int compareVersionV1(String a, String b) {
        int i = 0, j = 0;
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int a1 = 0, a2 = 0;
        int b1 = 0, b2 = 0;
        while (i < a.length() || j < b.length()) {
            a1 = i;
            b1 = j;
            while (i < a.length()) {
                if (charsA[i] == '.') {
                    a2 = i - 1;
                    break;
                } else if (i == a.length() - 1) {
                    a2 = i;
                    break;
                }
                i++;
            }
            while (j < b.length()) {
                if (charsB[j] == '.') {
                    b2 = j - 1;
                    break;
                } else if (j == b.length() - 1) {
                    b2 = j;
                    break;
                }
                j++;
            }
            String value1 = trimFirstZeros(a.substring(a1, a2 + 1));
            String value2 = trimFirstZeros(b.substring(b1, b2 + 1));
            if (value1.length() == 0 && value2.length() == 0 && i >= a.length() - 1 && j >= b.length() - 1) {
                return 0;
            } else if (value1.length() > value2.length()) {
                return 1;
            } else if (value1.length() < value2.length()) {
                return -1;
            } else {
                char[] charsV1 = value1.toCharArray();
                char[] charsV2 = value2.toCharArray();
                for (int k = 0; k < value1.length(); k++) {
                    if (charsV1[k] > charsV2[k]) {
                        return 1;
                    } else if (charsV1[k] < charsV2[k]) {
                        return -1;
                    }
                }
            }
            i++;
            j++;
        }
        return 0;
    }

    public int compareVersionV2(String a, String b) {
        String[] v1 = a.split("\\.");
        String[] v2 = b.split("\\.");
        int size = (v1.length <= v2.length) ? v1.length : v2.length;
        for (int i = 0; i < size; i++) {
            int comp = compare(v1[i], v2[i]);
            if (comp != 0) {
                return comp;
            }
        }
        if (v1.length != v2.length) {
            if (v1.length > v2.length) {
                for (int i = size; i < v1.length; i++) {
                    String s = trimFirstZeros(v1[i]);
                    if (s.length() != 0) {
                        return 1;
                    }
                }
            } else {
                for (int i = size; i < v2.length; i++) {
                    String s = trimFirstZeros(v2[i]);
                    if (s.length() != 0) {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }

    String trimFirstZeros(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == '0') {
            i++;
        }
        return str.substring(i, str.length());
    }

    int compare(String a, String b) {
        String v1 = trimFirstZeros(a);
        String v2 = trimFirstZeros(b);
        if (v1.length() > v2.length()) {
            return 1;
        } else if (v2.length() > v1.length()) {
            return -1;
        } else {
            char[] chars1 = v1.toCharArray();
            char[] chars2 = v2.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                char c1 = chars1[i];
                char c2 = chars2[i];
                if (c1 > c2) {
                    return 1;
                } else if (c2 > c1) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers instance = new CompareVersionNumbers();
        System.out.println(instance.compareVersionV2("1.2", "2.3"));
        System.out.println(instance.compareVersionV2("670.64.2951185", "417.7"));
    }
}
