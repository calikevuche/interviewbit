package Strings;

/**
 * Created by OlehKa on 06.08.2016.
 */
public class MultiplyStrings {

    public String multiply(String a, String b) {
        if (a.length() < b.length()) multiply(b, a);
        if (a.equals("0") || b.equals("0")) return "0";
        a = trimFirstZeros(a);
        b = trimFirstZeros(b);
        String result = "";
        char[] charsB = b.toCharArray();
        for (int i = 0; i < b.length(); i++) {
            int indexB = b.length() - 1 - i;
            String s = multiply(a, charsB[indexB] - '0');
            if (i == 0) {
                result = s;
            } else {
                result = addWithOffset1(result, s, i);
            }
        }
        return result;
    }

    public String multiply(String a, int num) {
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

    public String addWithOffset1(String a, String b, int offset) {
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

    String trimFirstZeros(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == '0') {
            i++;
        }
        return str.substring(i);
    }

    public static void main(String[] args) {
        MultiplyStrings instance = new MultiplyStrings();
//        System.out.println(instance.multiply("7481", 6));
//        System.out.println(instance.addWithOffset1("22443", "37405", 1));
//        System.out.println(instance.addWithOffset1("396493", "44886", 2));
//        System.out.println(instance.multiply("7481", "653"));
//        System.out.println(instance.multiply("0", "7481"));
//        System.out.println(instance.multiply("1", "7481"));
        System.out.println(instance.multiply("5131848155574784703269632922904933776792735241197982102373370", "56675688419586288442134264892419611145485574406534291250836"));
        System.out.println(instance.multiply("6020453667958309279424408570378228292268488402", "0021473700594524297017810575200827941459805716642468749607585313713214621412"));

    }
}
