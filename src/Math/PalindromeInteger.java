package Math;

/**
 * Created by OlehKa on 16.06.2016.
 */
public class PalindromeInteger {

    public boolean isPalindrome2(int a) {
        if (a < 0) return false;
        String reversed = "";
        for (char digit : Integer.toString(a).toCharArray()) {
            reversed = digit+reversed;
        }
        if (Long.parseLong(reversed) > Integer.MAX_VALUE) return false;
        return Integer.parseInt(reversed) == a;
    }

    public boolean isPalindrome(int a) {
        if (a < 0) return false;
        return reverse(a) == a;
    }

    private int reverse(int a) {
        int digit = 0;
        int rev = 0;
        while (a > 0) {
            digit = a % 10;
            if (rev > (Integer.MAX_VALUE / 10) || rev == (Integer.MAX_VALUE / 10) && digit > (Integer.MAX_VALUE % 10)) {
                return -1;
            }
            rev = rev * 10 + digit;
            a /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        PalindromeInteger instance = new PalindromeInteger();
        System.out.println(instance.isPalindrome(12121));
        System.out.println(instance.isPalindrome(12122));
        System.out.println(instance.isPalindrome(1000000003));
    }
}
