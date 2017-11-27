package Backtracking;

import java.util.ArrayList;

/**
 * Created by OlehKa on 07.11.2016.
 */
public class GenerateAllParentheses2 {

    public ArrayList<String> generateParenthesis(int a) {
        ArrayList<String> result = new ArrayList<>();
        generateParenthesis(2 * a, 2 * a, result);
        return result;
    }

    private void generateParenthesis(int n, int max, ArrayList<String> list) {
        if (n < 1) return;
        if (list.isEmpty()) {
            n--;
            list.add("(");
            generateParenthesis(n, max, list);
        } else {

            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (s.length() == max) continue;
                if (getOpenedNumber(s) == n) {
                    int newLength = s.length() + n;
                    while (s.length() < newLength) {
                        s = s + ")";
                    }
                    list.remove(i);
                    list.add(i, s);
                    continue;
                }
                String s1 = s + "(";
                list.remove(i);
                list.add(i, s1);
                if (getOpenedNumber(s) > 0) {
                    String s2 = s + ")";
                    i++;
                    list.add(i, s2);
                }
            }

            n--;
            generateParenthesis(n, max, list);

        }
    }

    private int getOpenedNumber(String s) {
        int opened = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') opened++;
            else if (s.charAt(i) == ')') opened--;
        }
        return opened;
    }

    public static void main(String[] args) {
        GenerateAllParentheses2 instance = new GenerateAllParentheses2();
        ArrayList<String> res = instance.generateParenthesis(3);
    }
}
