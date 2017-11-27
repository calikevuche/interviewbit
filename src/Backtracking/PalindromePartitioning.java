package Backtracking;

import Strings.PalindromeString;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 06.11.2016.
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        if (a.length() == 1) {
            resultList.add(new ArrayList<>(Arrays.asList(a)));
            return resultList;
        }
        for (int i = 1; i < a.length(); i++) {
            String begin = a.substring(0, i);
            if (isPalindrome(begin)) {
                ArrayList<ArrayList<String>> lists = partition(a.substring(i));
                for (ArrayList<String> list : lists) {
                    list.add(0, begin);
                    resultList.add(list);
                }
            }
        }
        if (isPalindrome(a)) {
            resultList.add(new ArrayList<>(Arrays.asList(a)));
        }
        return resultList;
    }

    public boolean isPalindrome(String a) {
        StringBuilder sb = new StringBuilder();
        for (char c : a.toLowerCase().toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) sb.append(c);
        }
        int n = sb.length() - 1;
        if (n == -1) return true;
        for (int i = 0; i <= n / 2; i++) {
            if (sb.charAt(i) != sb.charAt(n - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning instance = new PalindromePartitioning();
        instance.partition("aabb");
    }
}
