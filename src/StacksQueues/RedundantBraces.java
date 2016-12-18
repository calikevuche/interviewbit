package StacksQueues;

import java.util.Stack;

/**
 * Created by OlehKa on 15.10.2016.
 */
public class RedundantBraces {

    //0 -> NO 1 -> YES
    public int braces(String a) {
        Stack braces = new Stack();
        Stack operators = new Stack();
        boolean opened = false;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '(') {
                braces.push(c);
                operators.push(1);
                opened = true;
            }
            else if (c == ')') {
                braces.pop();
                opened = true;
            }
            else if (opened && braces.size() > 0 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                operators.pop();
                opened = false;
            }
        }
        return operators.isEmpty() ? 0 : 1;
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
