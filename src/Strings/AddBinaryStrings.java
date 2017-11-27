package Strings;

/**
 * Created by OlehKa on 03.08.2016.
 */
public class AddBinaryStrings {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
        String result = "";
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
                    result += 0;
                    carry = 0;
                    break;
                case 1:
                    result += 1;
                    carry = 0;
                    break;
                case 2:
                    result += 0;
                    carry = 1;
                    break;
                case 3:
                    result += 1;
                    carry = 1;
                    break;
            }
            i++;
        }
        if (carry == 1) result += 1;
        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        AddBinaryStrings instance = new AddBinaryStrings();
        System.out.println(instance.addBinary("101", "111"));
        System.out.println(instance.addBinary("10", "111"));
        System.out.println(instance.addBinary("", ""));
    }
}
