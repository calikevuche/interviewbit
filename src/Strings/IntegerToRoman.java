package Strings;

/**
 * Created by OlehKa on 01.08.2016.
 */
public class IntegerToRoman {

    public String intToRoman(int a) {
        String result = "";
        while (a > 0) {
            if (a - 1000 >= 0) {
                result += "M";
                a -= 1000;
            } else if (a - 900 >= 0) {
                result += "CM";
                a -= 900;
            } else if (a - 500 >= 0) {
                result += "D";
                a -= 500;
            } else if (a - 400 >= 0) {
                result += "CD";
                a -= 400;
            } else if (a - 100 >= 0) {
                result += "C";
                a -= 100;
            } else if (a - 90 >= 0) {
                result += "XC";
                a -= 90;
            } else if (a - 50 >= 0) {
                result += "L";
                a -= 50;
            } else if (a - 40 >= 0) {
                result += "XL";
                a -= 40;
            } else if (a - 10 >= 0) {
                result += "X";
                a -= 10;
            } else if (a - 9 >= 0) {
                result += "IX";
                a -= 9;
            } else if (a - 5 >= 0) {
                result += "V";
                a -= 5;
            } else if (a - 4 >= 0) {
                result += "IV";
                a -= 4;
            } else if (a - 1 >= 0) {
                result += "I";
                a -= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntegerToRoman instance = new IntegerToRoman();
//        System.out.println(instance.intToRoman(1444));
//        System.out.println(instance.intToRoman(1789));
//        System.out.println(instance.intToRoman(1555));
//        System.out.println(instance.intToRoman(1553));
        System.out.println(instance.intToRoman(90));
    }
}
