package StacksQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by OlehKa on 26.10.2016.
 */
public class EvaluateExpression {

    public int evalRPN(ArrayList<String> a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.size(); i++) {
            String element = a.get(i);
            if (isOperator(element)) {
                if (stack.size() < 2) {
                    return 0;
                }
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                int res = calcExpession(num2, num1, element);
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(a.get(i)));
            }
        }
        return stack.size() == 1 ? stack.pop() : 0;
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int calcExpession(int num1, int num2, String operator) {
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


    public static void main(String[] args) {

    }
}
