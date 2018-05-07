package Strings;

/**
 * Created by OlehKa on 06.08.2016.
 */
public class MultiplyStrings {

    public String multiplyV1(String a, String b) {
        if (a.length() < b.length()) multiplyV1(b, a);
        if (a.equals("0") || b.equals("0")) return "0";
        a = trimFirstZeros(a);
        b = trimFirstZeros(b);
        String result = "";
        char[] charsB = b.toCharArray();
        for (int i = 0; i < b.length(); i++) {
            int indexB = b.length() - 1 - i;
            String s = multiplyV1(a, charsB[indexB] - '0');
            if (i == 0) {
                result = s;
            } else {
                result = addWithOffset1(result, s, i);
            }
        }
        return result;
    }

    private String multiplyV1(String a, int num) {
        StringBuilder result = new StringBuilder();
        char[] chars = a.toCharArray();
        int carry = 0, value;
        for (int i = 0; i < chars.length; i++) {
            int digit = chars[chars.length - i - 1] - '0';
            value = (digit * num + carry) % 10;
            carry = (digit * num + carry) / 10;
            result.insert(0, value);
        }
        if (carry != 0) result.insert(0, carry);
        return result.toString();
    }

    private String addWithOffset1(String a, String b, int offset) {
        StringBuilder result = new StringBuilder();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int maxLength = Math.max(a.length(), b.length() + offset);
        int carry = 0, value;
        for (int i = 0; i < maxLength; i++) {
            if (i < offset) {
                int digitA = charsA[a.length() - i - 1] - '0';
                result.insert(0, digitA);
            } else {
                int indexA = a.length() - 1 - i;
                int indexB = b.length() - i + offset - 1;
                int digitA = indexA < 0 ? 0 : charsA[indexA] - '0';
                int digitB = indexB < 0 ? 0 : charsB[indexB] - '0';
                value = (digitA + digitB + carry) % 10;
                carry = (digitA + digitB + carry) / 10;
                result.insert(0, value);
            }
        }
        if (carry != 0) result.insert(0, carry);
        return result.toString();
    }

    private String trimFirstZeros(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == '0') {
            i++;
        }
        return str.substring(i);
    }

    public String multiplyV2(String a, String b) {
        a = trimFirstZeros(a);
        b = trimFirstZeros(b);
        if (a.length() < b.length()) {
            return multiplyV2(b, a);
        }
        char ch = 0;
        String temp = "", result = "";
        for (int i = 0; i < b.length(); i++) {
            ch = b.charAt(b.length() - 1 - i);
            temp = multiplyV2(a, ch);
            result = add(result, temp, i);
        }
        return result.isEmpty() ? "0" : result;
    }

    private StringBuilder stringBuilder = new StringBuilder();

    private String multiplyV2(String a, char ch) {
        int carry = 0, x = ch - '0', y = 0;
        stringBuilder.delete(0, stringBuilder.length());
        char[] ar = a.toCharArray();
        for (int i = 0; i < ar.length; i++) {
            y = ar[ar.length - 1 - i] - '0';
            stringBuilder.append((x * y + carry) % 10);
            carry = (x * y + carry) / 10;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    private String add(String a, String b, int shift) {
        int carry = 0, x = 0, y = 0;
        stringBuilder.delete(0, stringBuilder.length());
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        for (int i = 0; i < shift; i++) {
            stringBuilder.append(A[A.length - 1 - i]);
        }
        for (int i = shift; i < A.length; i++) {
            x = A[A.length - 1 - i] - '0';
            y = B[B.length - 1 - i + shift] - '0';
            stringBuilder.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        for (int i = A.length; i < B.length + shift; i++) {
            y = B[B.length - 1 - i + shift] - '0';
            stringBuilder.append((carry + y) % 10);
            carry = (carry + y) / 10;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public String multiplyV3(String a, String b) {
        int[] ar = new int[a.length() + b.length()];
        int x = 0, y = 0, sum = 0, carry = 0;
        int a_i = 0, b_i = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            carry = 0;
            b_i = 0;
            x = a.charAt(i) - '0';
            for (int j = b.length() - 1; j >= 0; j--) {
                y = b.charAt(j) - '0';
                sum = x * y + ar[a_i + b_i] + carry;
                ar[a_i + b_i] = sum % 10;
                carry = sum / 10;
                b_i++;
            }
            if (carry != 0) {
                ar[a_i + b_i] += carry;
            }
            a_i++;
        }
        int i = ar.length -1;
        while (i >= 0 && ar[i] == 0) {
            i--;
        }
        if (i < 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < i + 1; j++) {
            stringBuilder.append(ar[j]);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStrings instance = new MultiplyStrings();
//        System.out.println(instance.multiplyV1("5131848155574784703269632922904933776792735241197982102373370",
//                "56675688419586288442134264892419611145485574406534291250836"));
//        System.out.println(instance.multiplyV1("6020453667958309279424408570378228292268488402",
//                "0021473700594524297017810575200827941459805716642468749607585313713214621412"));
//        System.out.println(instance.multiplyV3("5131848155574784703269632922904933776792735241197982102373370",
//                "56675688419586288442134264892419611145485574406534291250836"));
//        System.out.println(instance.multiplyV3("6020453667958309279424408570378228292268488402",
//                "0021473700594524297017810575200827941459805716642468749607585313713214621412"));
        System.out.println(instance.multiplyV3("999", "99"));
        System.out.println(instance.multiplyV3("0", "0"));
    }
}
