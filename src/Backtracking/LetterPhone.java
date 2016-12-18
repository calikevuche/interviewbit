package Backtracking;

import java.util.ArrayList;

/**
 * Created by OlehKa on 06.11.2016.
 */
public class LetterPhone
{

    public ArrayList<String> letterCombinations(String a) {
        if (a.length() == 0) {
            return new ArrayList<>();
        }
        if (a.length() == 1) {
            return getMapping(a);
        }
        ArrayList<String> res = new ArrayList<>();
        String firstDigit = String.valueOf(a.charAt(0));
        for (String s1: getMapping(firstDigit)) {
            ArrayList<String> combinations = letterCombinations(a.substring(1));
            for (String s2: combinations) {
                res.add(s1+s2);
            }
        }
        return res;
    }

    private ArrayList<String> getMapping(String digit) {
        ArrayList<String> res = new ArrayList<>();
        switch (digit) {
            case "1":
                res.add("1");
                break;
            case "2":
                res.add("a");
                res.add("b");
                res.add("c");
                break;
            case "3":
                res.add("d");
                res.add("e");
                res.add("f");
                break;
            case "4":
                res.add("g");
                res.add("h");
                res.add("i");
                break;
            case "5":
                res.add("j");
                res.add("k");
                res.add("l");
                break;
            case "6":
                res.add("m");
                res.add("n");
                res.add("o");
                break;
            case "7":
                res.add("p");
                res.add("q");
                res.add("r");
                res.add("s");
                break;
            case "8":
                res.add("t");
                res.add("u");
                res.add("v");
                break;
            case "9":
                res.add("w");
                res.add("x");
                res.add("y");
                res.add("z");
                break;
            case "0":
                res.add("0");
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        LetterPhone letterPhone = new LetterPhone();
        letterPhone.letterCombinations("234");

    }
}
