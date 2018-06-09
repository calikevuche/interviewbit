package StacksQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by OlehKa on 26.10.2016.
 */
public class ReversePolishNotation {

    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for (String element : A) {
            if (isOperator(element)) {
                if (stack.size() < 2) {
                    return 0;
                }
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = calcExpression(num2, num1, element);
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(element));
            }
        }
        return stack.size() == 1 ? stack.pop() : 0;
    }

    private boolean isOperator(String s) {
        return s.equals("+") ||
                s.equals("-") ||
                s.equals("*") ||
                s.equals("/");
    }

    private int calcExpression(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }
}
