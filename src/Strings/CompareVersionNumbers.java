package Strings;

/**
 * Created by OlehKa on 30.07.2016.
 */
public class CompareVersionNumbers {

    public int compareVersion(String a, String b) {
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

    String trimFirstZeros(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == '0') {
            i++;
        }
        return str.substring(i);
    }

    public static void main(String[] args) {
        CompareVersionNumbers instance = new CompareVersionNumbers();
        System.out.println(instance.compareVersion("1.2", "2.3"));
        System.out.println(instance.compareVersion("1.4", "1.3"));
        System.out.println(instance.compareVersion("1.4", "1.4"));
        System.out.println(instance.compareVersion("1.4.488", "1.12"));
        System.out.println(instance.compareVersion("14488", "112"));
        System.out.println(instance.compareVersion("", ""));
        System.out.println(instance.compareVersion("13.0", "13.0.4"));
        System.out.println(instance.compareVersion("4444371174137455", "5.168"));
        System.out.println(instance.compareVersion("444444444444444444444444", "4444444444444444444444444"));
        System.out.println(instance.compareVersion("01", "000001"));
        System.out.println(instance.compareVersion("1", "1.0"));
        System.out.println(instance.compareVersion("670.64.2951185", "417.7"));
    }
}
