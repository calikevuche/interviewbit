package Strings;

/**
 * Created by OlehKa on 03.08.2016.
 */
public class AddBinaryStrings {

    public String addBinaryV1(String a, String b) {
        if (a.length() < b.length()) return addBinaryV1(b, a);
        StringBuilder result = new StringBuilder();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int i = 0;
        int carry = 0;
        while (i < b.length() && carry == 0 || i < a.length()) {
            int numA = charsA[a.length() - 1 - i] - '0';
            int numB = i < b.length() ? charsB[b.length() - 1 - i] - '0' : 0;
            int sum = numA + numB + carry;
            switch (sum) {
                case 0:
                    result.append(0);
                    carry = 0;
                    break;
                case 1:
                    result.append(1);
                    carry = 0;
                    break;
                case 2:
                    result.append(0);
                    carry = 1;
                    break;
                case 3:
                    result.append(1);
                    carry = 1;
                    break;
            }
            i++;
        }
        if (carry == 1) result.append(1);
        return result.reverse().toString();
    }

    public String addBinaryV2(String a, String b) {
        if (a.length() < b.length()) {
            return addBinaryV2(b, a);
        }
        int carry = 0, x = 0, y = 0, sum = 0;
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < B.length; i++) {
            x = A[A.length - 1 - i] - '0';
            y = B[B.length - 1 - i] - '0';
            sum = (x + y + carry) % 2;
            carry = (x + y + carry) / 2;
            stringBuilder.append(sum);
        }
        for (int i = 0; i < A.length - B.length; i++) {
            x = A[A.length - B.length - 1 - i] - '0';
            sum = (x + carry) % 2;
            carry = (x + carry) / 2;
            stringBuilder.append(sum);
        }
        if (carry == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinaryStrings instance = new AddBinaryStrings();
        System.out.println(instance.addBinaryV2("1010110111001101101000", "1010110111001101101000"));
        System.out.println(instance.addBinaryV2("", ""));
    }
}
