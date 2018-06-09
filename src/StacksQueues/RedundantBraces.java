package StacksQueues;

import java.util.Stack;

/**
 * Created by OlehKa on 15.10.2016.
 */
public class RedundantBraces {

    //0 -> NO 1 -> YES
    public int braces(String a) {
        Stack<Character> braces = new Stack<>();
        Stack<Integer> operators = new Stack<>();
        boolean opened = false;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '(') {
                braces.push(c);
                operators.push(1);
                opened = true;
            } else if (c == ')') {
                braces.pop();
                opened = true;
            } else if (opened && braces.size() > 0 &&
                    (c == '+' || c == '-' || c == '*' || c == '/')) {
                operators.pop();
                opened = false;
            }
        }
        return operators.isEmpty() ? 0 : 1;
    }

    //0 -> NO 1 -> YES
    public int braces2(String a) {
        Stack<Character> braces = new Stack<>();
        Stack<Character> operators = new Stack<>();
        boolean firstOperator = false;
        char[] arr = a.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                braces.push(c);
                firstOperator = true;
            } else if (c == ')') {
                if (braces.isEmpty() || operators.isEmpty()) {
                    return 1;
                } else {
                    braces.pop();
                    operators.pop();
                }
                firstOperator = true;
            } else if (!braces.isEmpty() && firstOperator &&
                    (c == '+' || c == '-' || c == '*' || c == '/')) {
                operators.push(c);
                firstOperator = false;
            }
        }
        return braces.isEmpty() && operators.isEmpty() ? 0 : 1;
    }

    public static void main(String[] args) {
        RedundantBraces redundantBraces = new RedundantBraces();
//        System.out.println(redundantBraces.braces("(a+b)"));
//        System.out.println(redundantBraces.braces("a+(a+b)"));
//        System.out.println(redundantBraces.braces("(a+(a+b))"));
//        System.out.println(redundantBraces.braces("((a+d+(a+b)))"));
//        System.out.println(redundantBraces.braces("(a)"));
        System.out.println(redundantBraces.braces("(a+((b*c)+c))"));
    }
}
